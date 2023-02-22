package com.lee.culturalplanner.poimap

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.lee.culturalplanner.R
import com.lee.culturalplanner.base.BaseFragment
import com.lee.culturalplanner.databinding.AroundinfoMapFragmentLayoutBinding
import com.lee.culturalplanner.poimap.adapter.POIMapAdapter

class POIMapFragment : BaseFragment<AroundinfoMapFragmentLayoutBinding, POIMapViewModel>(), RecyclerView.OnItemTouchListener {
    override val layoutId: Int = R.layout.aroundinfo_map_fragment_layout
    override val viewModel: POIMapViewModel by viewModels()
    private lateinit var adapter: POIMapAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = POIMapAdapter()
        adapter.setViewModel(viewModel)
        dataBinding.poiInfoRecycler.adapter = adapter
        dataBinding.poiInfoRecycler.itemAnimator = null

        dataBinding.poiInfoRecycler.addOnItemTouchListener(this)
    }

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        TODO("Not yet implemented")
    }

    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
        TODO("Not yet implemented")
    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
        TODO("Not yet implemented")
    }

}