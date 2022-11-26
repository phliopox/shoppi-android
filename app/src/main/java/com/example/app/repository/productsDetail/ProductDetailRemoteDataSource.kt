package com.example.app.repository.productsDetail

import com.example.app.model.Product
import com.example.app.network.ApiClient

class ProductDetailRemoteDataSource(private val apiClient : ApiClient,private val productId : String) : ProductDetailDataSource {
    override suspend fun getProductDetailData(): Product {
        return apiClient.getProducts(productId)
    }
}