package com.example.app.model

import com.google.gson.annotations.SerializedName

data class Banner(
    @SerializedName("background_image_url") val backgroundImageUrl :String,
    val badge: BannerBadge,
    val label: String,
    @SerializedName("product_detail") val productDetail: Product
)
data class BannerBadge(
    val label :String,
    @SerializedName("background_color") val backgroundColor : String
)
data class Product(
    @SerializedName("product_id") val productId:String,
    @SerializedName("brand_name") val brandName :String,
    val label : String,
    @SerializedName("discount_rate") val discountRate: Int,
    val price: Int,
    val type : String?,
    @SerializedName("thumbnail_image") val thumbnailImageUrl:String?,
    @SerializedName("representative_image_url") val representativeImageUrl : String?,
    val descriptions : List<ProductDescriptions>?
)
data class ProductDescriptions( // 상품 상세 페이지 - 상품 이미지 list
    val id : String,
    @SerializedName("image_url") val imageUrl : String
)
