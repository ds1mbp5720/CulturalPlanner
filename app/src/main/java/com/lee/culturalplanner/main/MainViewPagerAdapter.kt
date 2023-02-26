package com.lee.culturalplanner.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.lee.culturalplanner.festival.FestivalFragment
import com.lee.culturalplanner.poimap.POIMapFragment
import com.lee.culturalplanner.timetable.TimetableFragment

class MainViewPagerAdapter (fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TimetableFragment()
            1 -> FestivalFragment()
            else -> POIMapFragment()
        }
    }

}