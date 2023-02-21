package com.lee.culturalplanner.timetable.daysheet.room

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.lee.culturalplanner.timetable.timesheet.data.TimeSheet

/**
 * room db에 timesheet list 저장용 형변환 변환 class
  */
class TimeSheetListConverters {
    @TypeConverter
    fun listToJson(value: MutableList<TimeSheet>):String? {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): MutableList<TimeSheet>?{
        return Gson().fromJson(value,Array<TimeSheet>::class.java)?.toMutableList()
    }
}