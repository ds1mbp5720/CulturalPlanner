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
    private val _position: MutableLiveData<Int> = MutableLiveData()
    val position: LiveData<Int> get() = _position

    companion object{
        private val TAB_ITEMS = listOf(R.drawable.ic_baseline_calendar_month_24, R.drawable.ic_baseline_view_list_24, R.drawable.ic_baseline_map_24)
    }

    init {
        _tabItems.postValue(TAB_ITEMS)
    }
    fun selectPosition(position: Int){
        _position.postValue(position)
    }

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