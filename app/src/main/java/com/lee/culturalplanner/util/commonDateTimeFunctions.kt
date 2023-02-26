package com.lee.culturalplanner.util

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.text.format.DateFormat
import androidx.lifecycle.MutableLiveData
import com.lee.culturalplanner.festival.data.FestivalInfoData
import java.text.SimpleDateFormat
import java.util.*


// 날짜 string format
fun dateStringFormat(month: Int, day: Int):String{
    return "${month+1}월 ${day}일"  // month 0월 부터 시작함
}

@SuppressLint("SimpleDateFormat")
fun getTodayDate(): Int{
    val dataFormat = SimpleDateFormat("yyyy-MM-dd")
    val date = dataFormat.format(System.currentTimeMillis()).toString().split("-")
    return (date[0] + date[1] + date[2]).toInt()
}

fun makeDatePickerDialog(context: Context, listener: DatePickerDialog.OnDateSetListener){
    val cal = Calendar.getInstance()
    DatePickerDialog(context,listener,cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),cal.get(
        Calendar.DAY_OF_MONTH)).show()
}
fun makeTimePickerDialog(context: Context, listener: TimePickerDialog.OnTimeSetListener){
    val cal = Calendar.getInstance()
    TimePickerDialog(context,listener,cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), DateFormat.is24HourFormat(context)).show()
}

// 날짜 지난 행사들 제외
fun filterByTodayDate(festivalList: MutableLiveData<FestivalInfoData>): MutableList<FestivalInfoData.CulturalEventInfo.Row> {
    val festivalRowList = mutableListOf<FestivalInfoData.CulturalEventInfo.Row>()
    for (i in 0 until festivalList.value?.culturalEventInfo?.row!!.size) {
        val endDate =
            filterFestivalDateInt(festivalList.value?.culturalEventInfo?.row!![i].eNDDATE)
        if (endDate >= getTodayDate()) {
            festivalRowList.add(festivalList.value!!.culturalEventInfo.row[i])
        }
    }
    return festivalRowList
}

fun filterFestivalDateInt(date: String): Int {
    val filterToList = date.split("-", " ") as MutableList<String>
    return (filterToList[0] + filterToList[1] + filterToList[2]).toInt()
}

fun filterInsertDateInt(year: Int, month: Int, day: Int): Int {
    val setMonth = if (month < 10) {
        "0$month"
    } else month.toString()
    val setDay = if (day < 10) {
        "0$day"
    } else day.toString()
    return (year.toString() + setMonth + setDay).toInt()
}