package com.example.app.ui.productsDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.model.CartItem
import com.example.app.model.Product
import com.example.app.repository.cart.CartRepository
import com.example.app.repository.productsDetail.ProductDetailRepository
import com.example.app.ui.common.Event
import kotlinx.coroutines.launch

class ProductDetailViewModel(
    private val productDetailRepository: ProductDetailRepository,
    private val cartRepository : CartRepository
):ViewModel(){

    private val _products = MutableLiveData<Product>()
    val products = _products

    private val _addCartEvent = MutableLiveData<Event<Unit>>()
    val addCartEvent :LiveData<Event<Unit>> = _addCartEvent

     fun loadProductDetail(productId : String){
        viewModelScope.launch {
            val remoteProduct = productDetailRepository.getData(productId)
            _products.value = remoteProduct
        }
    }

    fun addCart(product:Product){
        viewModelScope.launch {
            cartRepository.addCartItem(product)
            _addCartEvent.value=Event(Unit)
        }
    }

}