package com.lee.dateplanner.timetable.time.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.lee.culturalplanner.timetable.daysheet.room.Timetable
import com.lee.culturalplanner.timetable.timesheet.data.TimeSheet

@Dao
interface TimetableDAO {
    @Insert
    fun insertTimetable(timetable: Timetable)

    // 찾기
    @Query("SELECT * FROM timetable_tbl WHERE timetableId = :id")
    fun findTimetable(id: Int): MutableList<Timetable>

    // 추가, 일정 추가
    @Query("UPDATE timetable_tbl SET timeSheetList = :timesheet WHERE timetableId = :id")
    fun updateTimetable(timesheet: MutableList<TimeSheet>, id: Int)

    //날짜 정보 변경
    @Query("UPDATE timetable_tbl SET date = :date WHERE timetableId = :id")
    fun updateDate(date: String, id: Int)

    //삭제
    @Query("DELETE FROM timetable_tbl WHERE timetableId = :id")
    fun deleteTimetable(id: Int)

    // 전체 반환
    @Query("SELECT * FROM timetable_tbl")
    fun getAllTimetable(): LiveData<MutableList<Timetable>>


}