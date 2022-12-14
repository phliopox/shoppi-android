package com.example.app.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.app.model.Banner
import com.example.app.model.Promotion
import com.example.app.model.Title
import com.example.app.repository.home.HomeRepository
import com.example.app.ui.common.Event

class HomeViewModel (private val repository: HomeRepository): ViewModel(){

    private val _title = MutableLiveData<Title>()
    val title : LiveData<Title> = _title

    private val _topBanners = MutableLiveData<List<Banner>>()
    val topBanners : LiveData<List<Banner>> = _topBanners

    private val _promotion = MutableLiveData<Promotion>()
    val promotion : LiveData<Promotion> = _promotion

    private val _openProductEvent  = MutableLiveData<Event<String>>()
    val openProductEvent = _openProductEvent



    init {
        loadHomeData()
    }
    fun openProductDetail(productId:String){
        _openProductEvent.value=Event(productId)
    }

    private fun loadHomeData(){
        //TODO 앱 아키텍처 적용. -> homeFragment 와 데이터 요청 로직 분리, Datalayer -Repository 에 요청
        val homeData = repository.getHomeData()
        homeData?.let{
            _title.value = homeData.title
            _topBanners.value = homeData.topBanners
            _promotion.value = homeData.promotions
        }
    }
}