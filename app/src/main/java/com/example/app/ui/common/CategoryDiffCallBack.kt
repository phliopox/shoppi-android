package com.example.app.ui.common

import androidx.recyclerview.widget.DiffUtil
import com.example.app.model.Category

class CategoryDiffCallBack : DiffUtil.ItemCallback<Category>(){
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.categoryId == newItem.categoryId
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem == newItem
    }

}
