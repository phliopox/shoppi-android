package com.example.app.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.app.AssetLoader
import com.example.app.network.ApiClient
import com.example.app.repository.category.CategoryRemoteDataSource
import com.example.app.repository.category.CategoryRepository
import com.example.app.repository.categorydetail.CategoryDetailRemoteDataSource
import com.example.app.repository.categorydetail.CategoryDetailRepository
import com.example.app.repository.home.HomeAssetDataSource
import com.example.app.repository.home.HomeRepository
import com.example.app.repository.productsDetail.ProductDetailRemoteDataSource
import com.example.app.repository.productsDetail.ProductDetailRepository
import com.example.app.ui.category.CategoryViewModel
import com.example.app.ui.categorydetail.CategoryDetailViewModel
import com.example.app.ui.home.HomeViewModel
import com.example.app.ui.productsDetail.ProductDetailViewModel
import kotlin.IllegalArgumentException

class ViewModelFactory(private val context: Context,private val productId:String?): ViewModelProvider.Factory {

     override fun <T : ViewModel> create(modelClass: Class<T>): T {
         return when{
             modelClass.isAssignableFrom(HomeViewModel::class.java)-> {
             val repository = HomeRepository(HomeAssetDataSource(AssetLoader(context)))
             HomeViewModel(repository) as T
             }
             modelClass.isAssignableFrom(CategoryViewModel::class.java) -> {
                 val repository = CategoryRepository(CategoryRemoteDataSource(ApiClient.create()))
                 CategoryViewModel(repository) as T
             }
             modelClass.isAssignableFrom(CategoryDetailViewModel::class.java)->{
                 val repository = CategoryDetailRepository(CategoryDetailRemoteDataSource(ApiClient.create()))
                 CategoryDetailViewModel(repository) as T
             }
             modelClass.isAssignableFrom(ProductDetailViewModel::class.java)->{
                 //이곳 람다 ?let
                 if(productId!=null){
                     val repository = ProductDetailRepository(ProductDetailRemoteDataSource(ApiClient.create(), productId))
                    ProductDetailViewModel(repository) as T
                 }else{
                     throw IllegalArgumentException("ProductID Not Exist : ${modelClass.name}")
                 }
             }
             else -> {
                 throw IllegalArgumentException("Failed to create ViewModel : ${modelClass.name}")
             }
         }
    }
}