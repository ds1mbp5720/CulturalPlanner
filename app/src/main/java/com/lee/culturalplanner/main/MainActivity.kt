package com.lee.culturalplanner.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.lee.culturalplanner.R
import com.lee.culturalplanner.base.BaseActivity
import com.lee.culturalplanner.databinding.ActivityMainBinding


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val layoutId: Int = R.layout.activity_main
    override val viewModel: MainViewModel by viewModels()
    private val tabTextList = listOf("Schedule", "Festival", "MapInfo")
    private val tabIconList = listOf(
        R.drawable.ic_baseline_calendar_month_24,
        R.drawable.ic_baseline_view_list_24,
        R.drawable.ic_baseline_map_24
    )

    private var currentPage = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(dataBinding.root)
        dataBinding.viewpagerMain.adapter = MainViewPagerAdapter(this)
        dataBinding.viewpagerMain.currentItem = currentPage
        dataBinding.viewpagerMain.offscreenPageLimit = 3
        TabLayoutMediator(
            dataBinding.tlTabLayout, dataBinding.viewpagerMain
        ) { tab, position ->
            tab.text = tabTextList[position]
            tab.setIcon(tabIconList[position])
        }.attach()

        dataBinding.viewpagerMain.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            var currentState = 0
            var currentPosition = 0
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                currentPage = position
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                if (currentState == ViewPager2.SCROLL_STATE_DRAGGING && currentPosition == position) {
                    if (currentPosition == 0) dataBinding.viewpagerMain.currentItem = 2
                    else if (currentPosition == 2) dataBinding.viewpagerMain.currentItem = 0
                }
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageScrollStateChanged(state: Int) {
                currentState = state
                super.onPageScrollStateChanged(state)
            }
        })
    }

    override fun initObserve() {
        super.initObserve()
        viewModel.eventClick.observe(this) {
            when (it) {
                MainViewModel.Event.TimeTable -> {
                    dataBinding.viewpagerMain.currentItem = 0
                }
                MainViewModel.Event.Festival -> dataBinding.viewpagerMain.currentItem = 1
                MainViewModel.Event.POIMap -> dataBinding.viewpagerMain.currentItem = 2
            }
        }
    }
}