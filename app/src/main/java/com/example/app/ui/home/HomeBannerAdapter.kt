package com.example.app.ui.home

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.app.model.Banner
import com.example.app.GlideApp
import com.example.app.R
import com.example.app.databinding.ItemHomeBannerBinding
import java.text.DecimalFormat
import kotlin.math.roundToInt

class HomeBannerAdapter (private val viewModel: HomeViewModel): ListAdapter<Banner, HomeBannerAdapter.HomeBannerViewHolder>(
    BannerDiffCallback()
){
    private lateinit var binding: ItemHomeBannerBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeBannerViewHolder {
        binding = ItemHomeBannerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return HomeBannerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeBannerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    inner class HomeBannerViewHolder(private val binding: ItemHomeBannerBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(banner : Banner){
            binding.banner= banner
            binding.viewModel = viewModel
            binding.executePendingBindings()

        }

        private fun calculateDiscountAmount(view:TextView ,discountRate: Int, price: Int){
            val discountPrice = ((100 - discountRate) / 100.0 * price).roundToInt()
            applyPriceFormat(view,discountPrice)
        }

        @SuppressLint("SetTextI18n")
        private fun applyPriceFormat(view :TextView, price: Int){
            val decimalFormat = DecimalFormat("#,###")
            view.text = decimalFormat.format(price) +"원"
        }


        fun loadImage(urlString: String, imageView: ImageView) {
            GlideApp.with(itemView)
                .load(urlString)
                .into(imageView)
        }
    }
}

class BannerDiffCallback : DiffUtil.ItemCallback<Banner>(){
    override fun areItemsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        return oldItem.productDetail.productId == newItem.productDetail.productId
    }

    //위의 메소드 호출되었을 때 true 이면 아래의 메소드로 나머지 프로퍼티 비교해서 같은 객체인지 판단.
    override fun areContentsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        return oldItem == newItem
    }

}