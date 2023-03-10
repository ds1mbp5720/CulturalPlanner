package com.lee.culturalplanner.festival.network

import com.lee.culturalplanner.BuildConfig
import com.lee.culturalplanner.festival.data.FestivalInfoData
import com.lee.culturalplanner.festival.data.FestivalSpaceData
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

const val FESTIVAL_ADDRESS = "http://openapi.seoul.go.kr:8088/${BuildConfig.FESTIVAL_KEY}/json/"

interface FestivalRetrofitService {
    @GET("culturalEventInfo/1/200/{CODENAME}") // 행사 정보 api
    suspend fun getFestivalInfo(
        @Path("CODENAME") CODENAME:String
    ): Response<FestivalInfoData>
    @GET("culturalSpaceInfo/1/819/") // 행사 장소 정보 api
    suspend fun getFestivalPlace(): Response<FestivalSpaceData>

    @GET("culturalEventInfo/{START_INDEX}/{END_INDEX}/{CODENAME}") // 페이징 목적 행사 정보 ap
    suspend fun getPagingFestivalInfo(
        @Path("START_INDEX") START_INDEX:Int,
        @Path("END_INDEX") END_INDEX:Int,
        @Path("CODENAME") CODENAME:String
    ): Response<FestivalInfoData>

    companion object {
        private var retrofitService: FestivalRetrofitService? = null
        fun getInstance() : FestivalRetrofitService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(FESTIVAL_ADDRESS)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(FestivalRetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}