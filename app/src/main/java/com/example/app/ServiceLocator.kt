package com.example.app

import com.example.app.network.ApiClient

/**
 * 여러개의 객체 생성 방지 목적
 */
object ServiceLocator {
    private var apiClient: ApiClient? = null

    fun provideApiClient(): ApiClient{
        return apiClient ?: kotlin.run{
            ApiClient.create().also{
                apiClient = it

            }
        }
    }
}