package com.lee.culturalplanner.timetable

import android.app.Application
import com.lee.culturalplanner.base.BaseViewModel

class TimetableViewModel (application: Application) : BaseViewModel(application) {

    sealed class Event {
        object First : Event()
        object OrderRefresh : Event()
    }
}