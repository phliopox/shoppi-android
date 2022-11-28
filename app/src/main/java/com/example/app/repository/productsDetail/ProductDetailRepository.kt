package com.example.app.repository.productsDetail

import com.example.app.model.Product

class ProductDetailRepository(private val productDetailRemoteDataSource: ProductDetailRemoteDataSource) {
        suspend fun getData(productId : String) : Product{
            return productDetailRemoteDataSource.getProductDetailData(productId)
        }
}