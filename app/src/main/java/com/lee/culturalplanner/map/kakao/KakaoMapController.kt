package com.lee.culturalplanner.map.kakao

import android.view.LayoutInflater
import android.view.View
import com.lee.culturalplanner.databinding.KakaoMapBalloonBinding
import com.lee.culturalplanner.map.base.BaseMapController
import com.lee.culturalplanner.map.data.BaseMapData
import net.daum.android.map.util.BitmapUtils.createBitmapFromView
import net.daum.mf.map.api.*

class KakaoMapController (private val mapView: MapView) : BaseMapController(), MapView.POIItemEventListener {
    private var isLocation = false
    private val mapMarkerClick = hashMapOf<Int, () -> (Unit)>()

    init {
        mapView.setZoomLevel(3, true)
        mapView.zoomIn(true)
        mapView.zoomOut(true)
        mapView.setPOIItemEventListener(this)
//        mapView.setCalloutBalloonAdapter(BalloonAdapter())
    }

    override fun clear() {
        mapView.removeAllPolylines()
        mapView.removeAllPOIItems()
        mapMarkerClick.clear()
    }

    override fun addMarker(item: BaseMapData.MarkerItem) {
        mapView.findPOIItemByTag(item.hash)?.apply {
            if (!item.isKakaoRemove) {
                mapPoint = MapPoint.mapPointWithGeoCoord(item.mapPoint.first, item.mapPoint.second)
            } else {
                this.customImageBitmap.recycle()
                mapView.removePOIItem(this)
                val marker = MapPOIItem()
                marker.itemName = item.name
                marker.markerType = MapPOIItem.MarkerType.CustomImage
                marker.mapPoint =
                    MapPoint.mapPointWithGeoCoord(item.mapPoint.first, item.mapPoint.second)
                marker.customImageBitmap = createBitmapFromView(item.view.root)
                marker.tag = item.hash
                mapView.addPOIItem(marker)
            }
        } ?: run {
            val marker = MapPOIItem()
            marker.itemName = item.name
            marker.markerType = MapPOIItem.MarkerType.CustomImage
            marker.mapPoint =
                MapPoint.mapPointWithGeoCoord(item.mapPoint.first, item.mapPoint.second)
            marker.customImageBitmap = createBitmapFromView(item.view.root)
            marker.tag = item.hash
            mapView.addPOIItem(marker)
        }
    }

    override fun addMarker(item: BaseMapData.MarkerItem, action: () -> (Unit)) {
        mapMarkerClick[item.hash] = action
        addMarker(item)
    }

    override fun removeMarker(hash: Int) {
        mapView.findPOIItemByTag(hash)?.run {
            mapView.removePOIItem(this)
        }
    }

    override fun addPolyLine(item: BaseMapData.PolylineItem) {
        mapView.findPolylineByTag(item.hash)?.apply {
            mapView.removePolyline(this)
        }
        val polyline = MapPolyline()
        polyline.addPoint(
            MapPoint.mapPointWithGeoCoord(
                item.startPoint.first,
                item.startPoint.second
            )
        )
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(item.endPoint.first, item.endPoint.second))
        polyline.lineColor = item.color
        polyline.tag = item.hash
        mapView.addPolyline(polyline)
    }

    override fun addPolyLine(item: BaseMapData.PolylineItem, action: () -> Unit) {}

    override fun removePolyLine(hash: Int) {
        mapView.findPolylineByTag(hash)?.run {
            mapView.removePolyline(this)
        }
    }

    override fun onPOIItemSelected(view: MapView?, mapPOIItem: MapPOIItem?) {
        mapPOIItem?.apply {
            if (mapMarkerClick.containsKey(tag)) {
                mapMarkerClick[tag]?.invoke()
            }
        }
    }

    override fun onCalloutBalloonOfPOIItemTouched(view: MapView?, mapPOIItem: MapPOIItem?) {}

    override fun onCalloutBalloonOfPOIItemTouched(
        view: MapView?,
        mapPOIItem: MapPOIItem?,
        buttonType: MapPOIItem.CalloutBalloonButtonType?
    ) {
    }

    override fun onDraggablePOIItemMoved(
        view: MapView?,
        mapPOIItem: MapPOIItem?,
        mapPoint: MapPoint?
    ) {
    }

    inner class BalloonAdapter : CalloutBalloonAdapter {
        private var bind: KakaoMapBalloonBinding =
            KakaoMapBalloonBinding.inflate(LayoutInflater.from(mapView.context))

        override fun getCalloutBalloon(mapPOIItem: MapPOIItem?): View {
            bind.twContent.text = mapPOIItem?.itemName ?: ""
            return bind.root
        }

        override fun getPressedCalloutBalloon(mapPOIItem: MapPOIItem?): View {
            return bind.root
        }
    }
}