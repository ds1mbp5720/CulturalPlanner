package com.lee.culturalplanner.timetable.daysheet.room

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.lee.culturalplanner.timetable.timesheet.data.TimeSheet

@Entity(tableName = "timetable_tbl")
class Timetable(){
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "timetableId") // 구분 id
    var id: Int = 0

    @ColumnInfo(name = "timeSheetList") // 시간별 계획 리스트
    var timeSheetList = mutableListOf<TimeSheet>()

    @ColumnInfo(name = "date") // 계획 날짜
    var date: String = ""

    @Ignore
    constructor(id: Int, timeSheetList: MutableList<TimeSheet>, date: String) : this() {
        this.id = id
        this.timeSheetList = timeSheetList
        this.date = date
    }

    @Ignore
    constructor(timeSheetList: MutableList<TimeSheet>, date: String) : this() {
        this.timeSheetList = timeSheetList
        this.date = date
    }
}