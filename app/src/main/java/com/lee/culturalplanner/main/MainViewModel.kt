package com.lee.culturalplanner.main

import android.app.Application
import androidx.lifecycle.LiveData
import com.lee.culturalplanner.base.BaseViewModel
import com.lee.culturalplanner.base.SingleLiveEvent

class MainViewModel(application: Application): BaseViewModel(application) {

    private val _eventClick = SingleLiveEvent<Event>()
    val eventClick: LiveData<Event> get() = _eventClick

    fun onEventClick(event: Event) {
        _eventClick.value = event
    }

    sealed class Event {
        object TimeTable: Event()
        object Festival: Event()
        object POIMap: Event()
    }
}