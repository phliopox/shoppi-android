package com.example.app.model

import com.google.gson.annotations.SerializedName

data class CategoryDetail(
    @SerializedName("top-selling") val topSelling : TopSelling,
    val promotions : Promotion
    )

data class TopSelling(
    val title : Title,
    val categories:List<Category>
    )

data class Promotion(
    val title : Title,
    val items : List<Product>
)