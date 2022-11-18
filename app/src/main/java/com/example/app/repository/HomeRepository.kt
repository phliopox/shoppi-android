package com.example.app.repository

import com.example.app.model.HomeData

class HomeRepository(private val assetDataSource : HomeDataSource ) {

    fun getHomeData(): HomeData? {
            return assetDataSource.getHomeData()
    }
}