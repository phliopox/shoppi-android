package com.example.app.ui.productsDetail

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.app.databinding.ItemProductDetailDescriptionBinding
import com.example.app.model.ProductDescriptions

class DescriptionAdapter :ListAdapter<ProductDescriptions,DescriptionAdapter.ProductDescriptionsViewHolder>(ProductDescriptionsDiff()) {
    private lateinit var binding : ItemProductDetailDescriptionBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductDescriptionsViewHolder {

        binding = ItemProductDetailDescriptionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductDescriptionsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductDescriptionsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ProductDescriptionsViewHolder(
        private val binding : ItemProductDetailDescriptionBinding):ViewHolder(binding.root){

        fun bind(description : ProductDescriptions){
            binding.descriptions = description
            binding.executePendingBindings()
        }
    }
}

class ProductDescriptionsDiff : DiffUtil.ItemCallback<ProductDescriptions>(){
    override fun areItemsTheSame(
        oldItem: ProductDescriptions,
        newItem: ProductDescriptions
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: ProductDescriptions,
        newItem: ProductDescriptions
    ): Boolean {
        return oldItem == newItem
    }

}
