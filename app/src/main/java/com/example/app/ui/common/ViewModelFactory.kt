package com.example.app.ui.common

import android.content.Context
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.app.AssetLoader
import com.example.app.ServiceLocator
import com.example.app.network.ApiClient
import com.example.app.repository.cart.CartItemLocalDataSource
import com.example.app.repository.cart.CartRepository
import com.example.app.repository.category.CategoryRemoteDataSource
import com.example.app.repository.category.CategoryRepository
import com.example.app.repository.categorydetail.CategoryDetailRemoteDataSource
import com.example.app.repository.categorydetail.CategoryDetailRepository
import com.example.app.repository.home.HomeAssetDataSource
import com.example.app.repository.home.HomeRepository
import com.example.app.repository.productsDetail.ProductDetailRemoteDataSource
import com.example.app.repository.productsDetail.ProductDetailRepository
import com.example.app.ui.cart.CartViewModel
import com.example.app.ui.category.CategoryViewModel
import com.example.app.ui.categorydetail.CategoryDetailViewModel
import com.example.app.ui.home.HomeViewModel
import com.example.app.ui.productsDetail.ProductDetailViewModel
import kotlin.IllegalArgumentException

class ViewModelFactory(private val context: Context): ViewModelProvider.Factory {

     override fun <T : ViewModel> create(modelClass: Class<T>): T {
         return when {
             modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                 val repository = HomeRepository(HomeAssetDataSource(AssetLoader(context)))
                 HomeViewModel(repository) as T
             }
             modelClass.isAssignableFrom(CategoryViewModel::class.java) -> {
                 val repository =
                     CategoryRepository(CategoryRemoteDataSource(ServiceLocator.provideApiClient()))
                 CategoryViewModel(repository) as T
             }
             modelClass.isAssignableFrom(CategoryDetailViewModel::class.java) -> {
                 val repository =
                     CategoryDetailRepository(CategoryDetailRemoteDataSource(ServiceLocator.provideApiClient()))
                 CategoryDetailViewModel(repository) as T
             }
             modelClass.isAssignableFrom(ProductDetailViewModel::class.java) -> {
                 //이곳 람다 ?let
                 val repository =
                     ProductDetailRepository(ProductDetailRemoteDataSource(ServiceLocator.provideApiClient()))
                 ProductDetailViewModel(repository,ServiceLocator.provideCartRepository(context)) as T
             }
             modelClass.isAssignableFrom(CartViewModel::class.java) -> {
                 CartViewModel(ServiceLocator.provideCartRepository(context)) as T
             }
             else -> {
                 throw IllegalArgumentException("Failed to create ViewModel : ${modelClass.name}")
             }
         }
    }
}