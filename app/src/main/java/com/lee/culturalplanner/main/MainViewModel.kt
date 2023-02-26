package com.lee.culturalplanner.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lee.culturalplanner.R
import com.lee.culturalplanner.base.BaseViewModel
import com.lee.culturalplanner.base.SingleLiveEvent

class MainViewModel(application: Application): BaseViewModel(application) {
    private val _tabItems: MutableLiveData<List<Int>> = MutableLiveData()
    val tabItems: LiveData<List<Int>> get() = _tabItems

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