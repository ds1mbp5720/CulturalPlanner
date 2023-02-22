package com.lee.culturalplanner.festival.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lee.culturalplanner.base.BaseViewHolder
import com.lee.culturalplanner.databinding.FestivalInfoRecyclerBinding
import com.lee.culturalplanner.festival.FestivalViewModel
import com.lee.culturalplanner.festival.data.FestivalInfoData

class FestivalAdapter: RecyclerView.Adapter<BaseViewHolder>() {
    private val items = mutableListOf<FestivalInfoData.CulturalEventInfo.Row>()
    private lateinit var viewModel: FestivalViewModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val bind = FestivalInfoRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(bind)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBindViewHolder(items[position])
    }
    fun setViewModel(festivalViewModel: FestivalViewModel) {
        viewModel = festivalViewModel
    }

    inner class ViewHolder(private val binding: FestivalInfoRecyclerBinding) : BaseViewHolder(binding.root) {
        private var oldOrderTextSize = 0f

        override fun onBindViewHolder(data: Any?) {

        }
    }

    fun getItems() = items
    override fun getItemCount() = items.size
}