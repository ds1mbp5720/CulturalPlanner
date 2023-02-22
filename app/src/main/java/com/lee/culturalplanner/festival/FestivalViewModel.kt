package com.lee.culturalplanner.festival

import android.app.Application
import com.lee.culturalplanner.base.BaseViewModel

class FestivalViewModel(application: Application) : BaseViewModel(application) {

    sealed class Event {
        object First : Event()
        object OrderRefresh : Event()
    }
}