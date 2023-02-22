package com.lee.culturalplanner.poimap

import android.app.Application
import com.lee.culturalplanner.base.BaseViewModel

class POIMapViewModel (application: Application) : BaseViewModel(application) {

    sealed class Event {
        object First : Event()
        object OrderRefresh : Event()
    }
}