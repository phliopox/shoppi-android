package com.example.app.network

import com.example.app.model.Category
import com.example.app.model.CategoryDetail
import com.example.app.model.Product
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {

    @GET("categories.json")
    suspend fun getCategories() :List<Category>

    @GET("fashion-female.json")
    suspend fun getCategoryDetail(): CategoryDetail

    @GET("products/{productId}.json")
    suspend fun getProducts(@Path("productId") productId:String) : Product
    /*
    get path를 파라미터로 넘겨받는 방법도 있다.
    @GET("{categoryId}.json")
    suspend fun getCategoryDetail(@Path("categoryId") categoryId:String ): CategoryDetail*/

    companion object{
        private val baseUrl ="https://shoppi-6e603-default-rtdb.asia-southeast1.firebasedatabase.app/"

        fun create(): ApiClient{
            val logger = HttpLoggingInterceptor().apply{
                level = HttpLoggingInterceptor.Level.BASIC

            }
            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiClient::class.java)
        }
    }
}