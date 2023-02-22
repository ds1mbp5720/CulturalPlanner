package com.lee.culturalplanner.festival

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lee.culturalplanner.R
import androidx.fragment.app.viewModels
import com.lee.culturalplanner.base.BaseFragment
import com.lee.culturalplanner.databinding.FestivallistFragmentLayoutBinding
import com.lee.culturalplanner.festival.adapter.FestivalAdapter

class FestivalFragment:BaseFragment<FestivallistFragmentLayoutBinding, FestivalViewModel>(), RecyclerView.OnItemTouchListener {
    override val layoutId: Int = R.layout.festivallist_fragment_layout
    override val viewModel: FestivalViewModel by viewModels()
    private lateinit var adapter: FestivalAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = FestivalAdapter()
        adapter.setViewModel(viewModel)
        dataBinding.festivalList.adapter = adapter
        dataBinding.festivalList.itemAnimator = null

        dataBinding.festivalList.addOnItemTouchListener(this)
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