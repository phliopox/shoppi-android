package com.example.app.repository.cart

import com.example.app.model.CartItem
import com.example.app.model.Product
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CartRepository(private val localDataSource: CartItemLocalDataSource,
                     private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO) {

    suspend fun addCartItem(product: Product) {
        withContext(ioDispatcher){
            val cartItem = CartItem(  //데이터 타입 변환 (장바구니에 추가시점에는 product 타입)
                productId = product.productId,
                label = product.label,
                price = product.price,
                brandName = product.brandName?:"",
                thumbnailImageUrl = product.thumbnailImageUrl?:"",
                type = product.type?:"",
                amount = 1
            )
            localDataSource.addCartItem(cartItem)
        }
    }

    suspend fun getCartItems(): List<CartItem> {
        return withContext(ioDispatcher) { // 스레드 변경 -> viewModel에서 해당 메소드를 호출하기때문에.
            localDataSource.getCartItems()

        }
    }
}