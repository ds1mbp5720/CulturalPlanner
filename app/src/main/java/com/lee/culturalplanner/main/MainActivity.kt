package com.lee.culturalplanner.main

import android.content.ContentValues.TAG
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.lee.culturalplanner.R
import com.lee.culturalplanner.base.BaseActivity
import com.lee.culturalplanner.databinding.ActivityMainBinding
import com.lee.culturalplanner.util.bold
import com.lee.culturalplanner.util.normal


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val layoutId: Int = R.layout.activity_main
    override val viewModel: MainViewModel by viewModels()

    private var currentPage = 0
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        dataBinding.viewpagerMain.adapter = MainViewPagerAdapter(supportFragmentManager, lifecycle)
        dataBinding.viewpagerMain.currentItem = currentPage
        dataBinding.viewpagerMain.offscreenPageLimit = 3

        dataBinding.viewpagerMain.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                currentPage = position
                when (position) {
                    0 -> {
                        Log.e(TAG,"페이지 ${currentPage}")
                    }
                    1 -> {
                        Log.e(TAG,"페이지 ${currentPage}")
                    }
                    2 -> {
                        Log.e(TAG,"페이지 ${currentPage}")
                    }
                }
                dataBinding.tiTime.isSelected = position == 0
                dataBinding.tiFestival.isSelected = position == 1
                dataBinding.tiPoiMap.isSelected = position == 2
            }
        })
        TabLayoutMediator(dataBinding.tlTabLayout, dataBinding.viewpagerMain){ tab, position ->

        }.isAttached

    }

    override fun initObserve() {
        super.initObserve()
        viewModel.eventClick.observe(this) {
            when (it) {
                MainViewModel.Event.TimeTable -> dataBinding.viewpagerMain.currentItem = 0
                MainViewModel.Event.Festival -> dataBinding.viewpagerMain.currentItem = 1
                MainViewModel.Event.POIMap -> dataBinding.viewpagerMain.currentItem = 2
            }
        }
    }
}