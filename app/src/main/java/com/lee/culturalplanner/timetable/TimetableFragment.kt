package com.lee.culturalplanner.timetable

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.lee.culturalplanner.R
import com.lee.culturalplanner.base.BaseFragment
import com.lee.culturalplanner.databinding.AroundinfoMapFragmentLayoutBinding

class TimetableFragment : BaseFragment<AroundinfoMapFragmentLayoutBinding, TimetableViewModel>(), RecyclerView.OnItemTouchListener {
    override val layoutId: Int = R.layout.timetablelist_fragment_layout
    override val viewModel: TimetableViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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