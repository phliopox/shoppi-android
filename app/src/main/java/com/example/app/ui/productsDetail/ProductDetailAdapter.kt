package com.example.app.ui.productsDetail

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DiffUtil.DiffResult
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.app.databinding.FragmentProductDetailBinding
import com.example.app.databinding.ProductDetailBinding
import com.example.app.databinding.ProductDetailImageBinding
import com.example.app.model.Product

class ProductDetailAdapter :ListAdapter<Product,ProductDetailAdapter.ProductDetailViewHolder>(ProductDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductDetailViewHolder {
        val binding = ProductDetailBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductDetailViewHolder(binding)
        Log.d("ProductAdapter","호출")

    }

    override fun onBindViewHolder(holder: ProductDetailViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ProductDetailViewHolder(
        private val binding : ProductDetailBinding):ViewHolder(binding.root){
        fun bind(product : Product){
             binding.product = product
            Log.d("ProductAdapter",product.toString())
        }
    }

}

class ProductDiff : DiffUtil.ItemCallback<Product>(){
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.productId == newItem.productId
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }
}
