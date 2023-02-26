package com.lee.culturalplanner.festival

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lee.culturalplanner.base.BaseViewModel
import com.lee.culturalplanner.base.SingleLiveEvent
import com.lee.culturalplanner.festival.data.FestivalInfoData
import com.lee.culturalplanner.festival.data.FestivalSpaceData
import com.lee.culturalplanner.util.filterByTodayDate
import com.lee.culturalplanner.util.filterFestivalDateInt
import com.lee.culturalplanner.util.filterInsertDateInt
import com.lee.culturalplanner.util.toastMessage
import kotlinx.coroutines.*

class FestivalViewModel(application: Application) : BaseViewModel(application) {
    private lateinit var repository: FestivalRepository
    val festivalList = MutableLiveData<FestivalInfoData>()
    val festivalPlaceList = MutableLiveData<FestivalSpaceData>()
    val errorMessage = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>()
    private var job: Job? = null

    private val exceptionHandler = CoroutineExceptionHandler { _, thrownException ->
        onError("코루틴내 예외: ${thrownException.localizedMessage}")
    }

    fun getAllFestivalFromViewModel(category: String, year: Int = 0, month: Int = 0, day: Int = 0) {
        job = CoroutineScope(Dispatchers.IO).launch(exceptionHandler) {
            isLoading.postValue(true)
            val infoResponse = repository.getFestivalInfo(category) // 행사 정보
            withContext(Dispatchers.Main) {
                if (infoResponse.isSuccessful) {
                    festivalList.postValue(infoResponse.body())
                    isLoading.postValue(false)
                } else {
                    onError("에러내용 : ${infoResponse.message()}")
                }
            }
            withContext(Dispatchers.Main) {
                if (year != 0 && month != 0 && day != 0) {
                    festivalList.value!!.culturalEventInfo.row = filterByDate(year, month, day)
                } else {
                    festivalList.value!!.culturalEventInfo.row = filterByTodayDate(festivalList)
                }
                if (festivalList.value!!.culturalEventInfo.row.isEmpty()) {
                    toastMessage("예정된 행사가 없습니다.")
                }
            }
        }
    }

    private fun filterByDate(
        year: Int,
        month: Int,
        day: Int
    ): MutableList<FestivalInfoData.CulturalEventInfo.Row> {
        val insertDate = filterInsertDateInt(year, month, day)
        val festivalRowList = mutableListOf<FestivalInfoData.CulturalEventInfo.Row>()
        for (i in 0 until festivalList.value?.culturalEventInfo?.row!!.size) {
            val startDate =
                filterFestivalDateInt(festivalList.value?.culturalEventInfo?.row!![i].sTRTDATE)
            val endDate =
                filterFestivalDateInt(festivalList.value?.culturalEventInfo?.row!![i].eNDDATE)
            if (insertDate in startDate..endDate)
                festivalRowList.add(festivalList.value!!.culturalEventInfo.row[i])
        }
        return festivalRowList
    }

    private fun onError(message: String) {
        errorMessage.postValue(message)
        isLoading.postValue(false)
    }

    private val _dateClick = SingleLiveEvent<Unit>()
    val dateClick: LiveData<Unit> get() = _dateClick
    private val _categoryClick = SingleLiveEvent<String>()
    val categoryClick: LiveData<String> get() = _categoryClick

    fun onDateClick() {
        _dateClick.call()
    }
    fun onCategoryClick(){
        _categoryClick.call()
    }


    sealed class Event {
        object First : Event()
        object OrderRefresh : Event()
    }
}