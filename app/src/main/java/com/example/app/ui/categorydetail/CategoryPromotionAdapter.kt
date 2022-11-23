package com.example.app.ui.categorydetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.ItemCategoryPoromotionBinding
import com.example.app.model.Product

class CategoryPromotionAdapter :ListAdapter<Product,CategoryPromotionAdapter.CategoryPromotionViewHolder>(ProductDiffCallBack()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryPromotionViewHolder {
        val binding = ItemCategoryPoromotionBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CategoryPromotionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryPromotionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CategoryPromotionViewHolder(private val binding : ItemCategoryPoromotionBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(product : Product){
            binding.product = product
            binding.executePendingBindings()

        }
    }
}
class ProductDiffCallBack : DiffUtil.ItemCallback<Product>(){
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.productId == newItem.productId
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }

}