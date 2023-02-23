package com.lee.culturalplanner.map.data

import androidx.databinding.ViewDataBinding

object BaseMapData {

    data class MarkerItem(
        val hash: Int,
        val name: String,
        val mapPoint: Pair<Double, Double>,
        val view: ViewDataBinding,
        val isKakaoRemove:Boolean = false
    )

    data class PolylineItem(
        val hash: Int,
        val color: Int,
        val startPoint: Pair<Double, Double>,
        val endPoint: Pair<Double, Double>
    )

}