package com.example.app.repository.productsDetail

import com.example.app.model.Product
import com.example.app.network.ApiClient

class ProductDetailRemoteDataSource(private val apiClient : ApiClient) : ProductDetailDataSource {
    override suspend fun getProductDetailData(productId :String): Product {
        return apiClient.getProducts(productId)
    }
}