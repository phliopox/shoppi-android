package com.example.app.repository.productsDetail

import com.example.app.model.Product


interface ProductDetailDataSource {
   suspend fun getProductDetailData(productId:String) : Product
}