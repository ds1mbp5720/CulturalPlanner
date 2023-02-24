package com.lee.culturalplanner.main

import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Base64
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.lee.culturalplanner.R
import com.lee.culturalplanner.base.BaseActivity
import com.lee.culturalplanner.databinding.ActivityMainBinding
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val layoutId: Int = R.layout.activity_main
    override val viewModel: MainViewModel by viewModels()

    private var currentPage = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding.viewpagerMain.adapter = MainViewPagerAdapter(supportFragmentManager, lifecycle)
        dataBinding.viewpagerMain.currentItem = currentPage
        dataBinding.viewpagerMain.offscreenPageLimit = 3

        dataBinding.viewpagerMain.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                currentPage = position
                when (position){
                    0 -> {
                        //Todo 강조
                    }
                    1 -> {

                    }
                    2 -> {

                    }
                }
                dataBinding.tiTime.isSelected = position == 0
                dataBinding.tiFestival.isSelected = position == 1
                dataBinding.tiPoimap.isSelected = position == 2
            }
        })
    }

    override fun initObserve() {
        super.initObserve()
        viewModel.eventClick.observe(this){
            when(it){
                MainViewModel.Event.TimeTable -> dataBinding.viewpagerMain.currentItem = 0
                MainViewModel.Event.Festival -> dataBinding.viewpagerMain.currentItem = 1
                MainViewModel.Event.POIMap -> dataBinding.viewpagerMain.currentItem = 2
            }
        }
    }
}