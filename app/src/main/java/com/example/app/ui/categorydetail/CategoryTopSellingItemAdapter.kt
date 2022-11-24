package com.example.app.ui.categorydetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.ItemCategoryBinding
import com.example.app.databinding.ItemCategoryTopSellingBinding
import com.example.app.model.Category
import com.example.app.ui.common.CategoryDiffCallBack

class CategoryTopSellingItemAdapter : ListAdapter<Category,CategoryTopSellingItemAdapter.TopSellingItemViewHolder>(
    CategoryDiffCallBack()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopSellingItemViewHolder {
        val binding = ItemCategoryTopSellingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TopSellingItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TopSellingItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class TopSellingItemViewHolder(private val binding: ItemCategoryTopSellingBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(category : Category){
            binding.category = category
            binding.executePendingBindings()
        }
    }
}
