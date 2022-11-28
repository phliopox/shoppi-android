package com.example.app.ui.productsDetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.model.Product
import com.example.app.repository.productsDetail.ProductDetailRepository
import kotlinx.coroutines.launch

class ProductDetailViewModel(private val productDetailRepository: ProductDetailRepository):ViewModel(){

    private val _products = MutableLiveData<Product>()
    val products = _products
    /*init {
        loadData()
    }*/
     fun loadProductDetail(productId : String){
        viewModelScope.launch {
            val remoteProduct = productDetailRepository.getData(productId)
            _products.value = remoteProduct
        }
    }

}