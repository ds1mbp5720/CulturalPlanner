package com.lee.culturalplanner.festival

import android.app.DatePickerDialog
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lee.culturalplanner.R
import androidx.fragment.app.viewModels
import com.lee.culturalplanner.base.BaseFragment
import com.lee.culturalplanner.databinding.FestivallistFragmentLayoutBinding
import com.lee.culturalplanner.festival.adapter.FestivalAdapter
import com.lee.culturalplanner.util.dateStringFormat
import com.lee.culturalplanner.util.makeDatePickerDialog
import java.util.*

class FestivalFragment:BaseFragment<FestivallistFragmentLayoutBinding, FestivalViewModel>(), RecyclerView.OnItemTouchListener {
    override val layoutId: Int = R.layout.festivallist_fragment_layout
    override val viewModel: FestivalViewModel by viewModels()
    private lateinit var adapter: FestivalAdapter
    private var year = 0
    private var month = 0
    private var day = 0
    private var category: String = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = FestivalAdapter()
        adapter.setViewModel(viewModel)
        dataBinding.festivalList.adapter = adapter
        dataBinding.festivalList.itemAnimator = null

        dataBinding.festivalList.addOnItemTouchListener(this)
    }

    override fun initObserve() {
        super.initObserve()
        viewModel.dateClick.observe(this){
            context?.let { it1 ->
                DatePickerDialog(
                    it1,
                    { _, year, month, dayOfMonth ->
                        dataBinding.inputDate.text = dateStringFormat(month,dayOfMonth) // 날짜 버튼 text 변경
                        this.year = year
                        this.month = month + 1
                        this.day = dayOfMonth
                        viewModel.getAllFestivalFromViewModel(category, this.year, this.month, this.day)
                    }, Calendar.getInstance().get(Calendar.YEAR),Calendar.getInstance().get(Calendar.MONTH),Calendar.getInstance().get(Calendar.DATE)
                ).show()
            }
        }
        viewModel.categoryClick.observe(this){

        }

    }

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        TODO("Not yet implemented")
    }
    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {}
    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
        TODO("Not yet implemented")
    }

}