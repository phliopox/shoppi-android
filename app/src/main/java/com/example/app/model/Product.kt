package com.example.app.model

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("brand_name") val brandName :String,
    val label : String,
    @SerializedName("product_id") val productId:String,
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