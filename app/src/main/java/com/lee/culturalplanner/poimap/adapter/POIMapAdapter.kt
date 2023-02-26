package com.lee.culturalplanner.poimap.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lee.culturalplanner.base.BaseViewHolder
import com.lee.culturalplanner.databinding.PoiListRecyclerBinding
import com.lee.culturalplanner.poimap.POIMapViewModel
import com.lee.culturalplanner.poimap.data.POIData

class POIMapAdapter: RecyclerView.Adapter<BaseViewHolder>() {
    private val items = mutableListOf<POIData.Document>()
    private lateinit var viewModel:POIMapViewModel
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    fun setViewModel(poiMapViewModel: POIMapViewModel) {
        viewModel = poiMapViewModel
    }
    inner class ViewHolder(private val binding: PoiListRecyclerBinding) : BaseViewHolder(binding.root) {
        private var oldOrderTextSize = 0f

        override fun onBindViewHolder(data: Any?) {

        }
    }
    override fun getItemCount(): Int = items.size
}