package com.example.app.ui.productsDetail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.model.Product
import com.example.app.repository.productsDetail.ProductDetailRepository
import kotlinx.coroutines.launch

class ProductDetailViewModel(private val productDetailRepository: ProductDetailRepository):ViewModel(){

    private val _products = MutableLiveData<List<Product>>()
    val products = _products
    init {
        loadData()
    }
    private fun loadData(){
        viewModelScope.launch {
            val remoteProduct = productDetailRepository.getData()
            _products.value = remoteProduct
            Log.d("ProductViewModel",_products.value.toString())
        }
    }

}