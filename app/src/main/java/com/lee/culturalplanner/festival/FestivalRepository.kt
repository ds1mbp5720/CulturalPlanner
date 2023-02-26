package com.lee.culturalplanner.festival

import com.lee.culturalplanner.festival.network.FestivalRetrofitService

class FestivalRepository constructor(private val festivalRetrofitService: FestivalRetrofitService) {
    //행사 정보
    suspend fun getFestivalInfo(category: String) = festivalRetrofitService.getFestivalInfo(category)

    suspend fun getPagingFestivalInfo(category: String, start: Int, end: Int) = festivalRetrofitService.getPagingFestivalInfo(start,end,category)

    //행사 장소
    suspend fun getFestivalPlace() = festivalRetrofitService.getFestivalPlace()
}