package com.example.app.ui.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.ItemCategoryBinding
import com.example.app.model.Category

class CategoryAdapter(private val viewModel : CategoryViewModel): ListAdapter<Category,CategoryAdapter.CategoryViewHolder>(CategoryDiffCallBack()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding =ItemCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(getItem(position))

    }

    inner class CategoryViewHolder(private val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category){
            binding.viewModel= viewModel
            binding.category = category
            binding.executePendingBindings()
        }
    }
}
class CategoryDiffCallBack : DiffUtil.ItemCallback<Category>(){
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.categoryId == newItem.categoryId
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem == newItem
    }

}