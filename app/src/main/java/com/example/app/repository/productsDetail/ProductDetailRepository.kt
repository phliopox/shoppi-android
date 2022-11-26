package com.example.app.repository.productsDetail

import com.example.app.model.Product

class ProductDetailRepository(private val productDetailRemoteDataSource: ProductDetailRemoteDataSource) {
        suspend fun getData() : List<Product>{
            return productDetailRemoteDataSource.getProductDetailData()
        }
}