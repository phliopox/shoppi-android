package com.example.app.repository.categorydetail

import com.example.app.model.CategoryDetail

class CategoryDetailRepository(private val remoteDatasource: CategoryDetailRemoteDataSource){

    suspend fun getCategoryDetail():CategoryDetail{
        return remoteDatasource.getCategoryDetail()
    }
}