package com.example.app.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.ItemCartSectionBinding
import com.example.app.databinding.ItemCartSectionHeaderBinding
import com.example.app.model.CartHeader
import com.example.app.model.CartItem
import com.example.app.model.CartProduct


private const val VIEW_TYPE_HEADER = 0
private const val VIEW_TYPE_ITEM = 1

class CartAdapter :RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val cartProducts = mutableListOf<CartProduct>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            VIEW_TYPE_HEADER -> HeaderViewHolder(ItemCartSectionHeaderBinding.inflate(inflater,parent,false))
            else -> ItemViewHolder(ItemCartSectionBinding.inflate(inflater,parent,false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder){
            is HeaderViewHolder->{
                val item = cartProducts[position] as CartHeader
                holder.bind(item)
            }
            is ItemViewHolder ->{
                val item = cartProducts[position] as CartItem
                holder.bind(item)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(cartProducts[position]){
            is CartHeader -> VIEW_TYPE_HEADER
            is CartItem ->VIEW_TYPE_ITEM
        }
    }

    override fun getItemCount(): Int {
        return cartProducts.size
    }

    class HeaderViewHolder(private val binding : ItemCartSectionHeaderBinding) :RecyclerView.ViewHolder(binding.root){
        fun bind(cartHeader: CartHeader){
            binding.brandName = cartHeader
            binding.executePendingBindings()
        }
    }
    class ItemViewHolder(private val binding : ItemCartSectionBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(cartItem: CartItem){
            binding.cartItem = cartItem
            binding.executePendingBindings()
        }
    }
}