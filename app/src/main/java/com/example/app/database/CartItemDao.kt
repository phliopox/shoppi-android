package com.example.app.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.app.model.CartItem

@Dao
interface CartItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) // 같은 데이터 있다면 변경시에만 insert
    suspend fun insert(cartItem: CartItem)

    @Query("SELECT * FROM cart_item")
    suspend fun load ():List<CartItem>
}