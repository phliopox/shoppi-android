package com.example.app.ui.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.ItemTitleBinding
import com.example.app.model.Title

class TitleSectionTitleAdapter :ListAdapter<Title, TitleSectionTitleAdapter.TitleSectionTitleViewHolder>(
    TitleDiffCallBack()
) {

//    private lateinit var binding : ItemTitleBinding

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TitleSectionTitleViewHolder {
        val binding =  ItemTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TitleSectionTitleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TitleSectionTitleViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class TitleSectionTitleViewHolder(private val binding : ItemTitleBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(title : Title) {
            binding.title = title
            binding.executePendingBindings()
        }

    }

}
class TitleDiffCallBack : DiffUtil.ItemCallback<Title>(){
    override fun areItemsTheSame(oldItem: Title, newItem: Title): Boolean {
        return oldItem.text == newItem.text
    }

    override fun areContentsTheSame(oldItem: Title, newItem: Title): Boolean {
        return oldItem==newItem
    }

}