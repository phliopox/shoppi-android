package com.example.app

import android.content.Context
import androidx.room.Room
import com.example.app.database.AppDataBase
import com.example.app.network.ApiClient
import com.example.app.repository.cart.CartItemLocalDataSource
import com.example.app.repository.cart.CartRepository

/**
 * 여러개의 객체 생성 방지 목적
 */
object ServiceLocator {
    private var apiClient: ApiClient? = null
    private var database : AppDataBase?= null
    private var cartRepository: CartRepository? = null

    fun provideApiClient(): ApiClient{
        return apiClient ?: kotlin.run{
            ApiClient.create().also{
                apiClient = it

            }
        }
    }

   private fun provideDatabase(applicationContext: Context): AppDataBase {
        return database ?: kotlin.run{
            Room.databaseBuilder(
                applicationContext,
                AppDataBase::class.java,
                "shoppi-local"
            ).build().also {
                database = it
            }
        }
    }

    fun provideCartRepository(context : Context):CartRepository{
        return cartRepository?:kotlin.run {
            val dao = provideDatabase(context.applicationContext).cartItemDao()
            CartRepository(CartItemLocalDataSource(dao)).also {
                cartRepository = it
            }
        }
    }
}