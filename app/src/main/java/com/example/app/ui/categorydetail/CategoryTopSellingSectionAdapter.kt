package com.example.app.ui.categorydetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.ItemCategoryTopSellingSectionBinding
import com.example.app.model.TopSelling

class CategoryTopSellingSectionAdapter :ListAdapter<TopSelling,CategoryTopSellingSectionAdapter.CategoryTopSellingViewHolder>(CategoryTopSellingSectionDiffUtil()){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryTopSellingViewHolder {
        val binding = ItemCategoryTopSellingSectionBinding.inflate(LayoutInflater.from(parent.context),parent,false)
       return CategoryTopSellingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryTopSellingViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CategoryTopSellingViewHolder(private val binding : ItemCategoryTopSellingSectionBinding):RecyclerView.ViewHolder(binding.root){
        private val nestedAdapter = CategoryTopSellingItemAdapter()
        init{
            binding.rvCategorySection.adapter = nestedAdapter
        }

        fun bind(topSelling : TopSelling){
            binding.title = topSelling.title
            binding.executePendingBindings()
            nestedAdapter.submitList(topSelling.categories)
        }
    }
}
class CategoryTopSellingSectionDiffUtil : DiffUtil.ItemCallback<TopSelling>() {
    override fun areItemsTheSame(oldItem: TopSelling, newItem: TopSelling): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: TopSelling, newItem: TopSelling): Boolean {
        return oldItem==newItem
    }

}