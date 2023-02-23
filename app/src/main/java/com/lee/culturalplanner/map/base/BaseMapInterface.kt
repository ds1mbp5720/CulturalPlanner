package com.lee.culturalplanner.map.base

import com.lee.culturalplanner.map.data.BaseMapData

interface BaseMapInterface {

    abstract fun addMarker(item: BaseMapData.MarkerItem)

    abstract fun addMarker(item: BaseMapData.MarkerItem, action: () -> (Unit))

    abstract fun removeMarker(hash: Int)

    abstract fun addPolyLine(item: BaseMapData.PolylineItem)

    abstract fun addPolyLine(item: BaseMapData.PolylineItem, action: () -> (Unit))

    abstract fun removePolyLine(hash: Int)

    abstract fun clear()
}