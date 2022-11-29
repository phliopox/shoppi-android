package com.example.app.ui.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.ItemProductPoromotionBinding
import com.example.app.model.Product
import com.example.app.ui.home.HomeFragment

class ProductPromotionAdapter(private val navigator : HomeFragment.NavigateByProductId?) :ListAdapter<Product, ProductPromotionAdapter.ProductPromotionViewHolder>(
    ProductDiffCallBack()
){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductPromotionViewHolder {
        val binding = ItemProductPoromotionBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductPromotionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductPromotionViewHolder, position: Int) {
        holder.bind(getItem(position))

        holder.itemView.setOnClickListener {
            val productId = getItem(position).productId
            navigator?.let{ navigator.navigateByProductId(productId) }
        }

    }

    inner class ProductPromotionViewHolder(private val binding : ItemProductPoromotionBinding) : RecyclerView.ViewHolder(binding.root){
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