package com.lee.culturalplanner.map.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.lee.culturalplanner.R
import com.lee.culturalplanner.base.BaseFragment
import com.lee.culturalplanner.databinding.MapFragmentBinding
import com.lee.culturalplanner.map.data.BaseMapData
import com.lee.culturalplanner.map.kakao.KakaoMapController
import com.lee.culturalplanner.map.viewmodel.BaseMapViewModel
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView

class BaseMapFragment : BaseFragment<MapFragmentBinding, BaseMapViewModel>(), BaseMapInterface {
    override val layoutId: Int = R.layout.map_fragment
    override val viewModel: BaseMapViewModel by viewModels()
    private var mapView: MapView = MapView(this.context)

    private lateinit var mapController: BaseMapController
    private val kakaoClickEvent by lazy {
        object : MapView.MapViewEventListener{
            override fun onMapViewInitialized(p0: MapView?) {
                TODO("Not yet implemented")
            }

            override fun onMapViewCenterPointMoved(p0: MapView?, p1: MapPoint?) {
                TODO("Not yet implemented")
            }

            override fun onMapViewZoomLevelChanged(p0: MapView?, p1: Int) {
                TODO("Not yet implemented")
            }

            override fun onMapViewSingleTapped(p0: MapView?, p1: MapPoint?) {
                TODO("Not yet implemented")
            }

            override fun onMapViewDoubleTapped(p0: MapView?, p1: MapPoint?) {
                TODO("Not yet implemented")
            }

            override fun onMapViewLongPressed(p0: MapView?, p1: MapPoint?) {
                TODO("Not yet implemented")
            }

            override fun onMapViewDragStarted(p0: MapView?, p1: MapPoint?) {
                TODO("Not yet implemented")
            }

            override fun onMapViewDragEnded(p0: MapView?, p1: MapPoint?) {
                TODO("Not yet implemented")
            }

            override fun onMapViewMoveFinished(p0: MapView?, p1: MapPoint?) {
                TODO("Not yet implemented")
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val lifecycleObserver = object : DefaultLifecycleObserver {
            override fun onResume(owner: LifecycleOwner) {
                super.onResume(owner)
                mapView.setMapViewEventListener(kakaoClickEvent)
                mapController = KakaoMapController(mapView)
                dataBinding.mapView.addView(mapView)
            }

            override fun onPause(owner: LifecycleOwner) {
                super.onPause(owner)
                dataBinding.mapView.removeView(mapView)
                mapView.onSurfaceDestroyed()
                mapView = MapView(this@BaseMapFragment.context)
            }
        }
    }

    override fun addMarker(item: BaseMapData.MarkerItem) {
        TODO("Not yet implemented")
    }

    override fun addMarker(item: BaseMapData.MarkerItem, action: () -> Unit) {
        TODO("Not yet implemented")
    }

    override fun removeMarker(hash: Int) {
        TODO("Not yet implemented")
    }

    override fun addPolyLine(item: BaseMapData.PolylineItem) {
        TODO("Not yet implemented")
    }

    override fun addPolyLine(item: BaseMapData.PolylineItem, action: () -> Unit) {
        TODO("Not yet implemented")
    }

    override fun removePolyLine(hash: Int) {
        TODO("Not yet implemented")
    }

    override fun clear() {
        TODO("Not yet implemented")
    }

}