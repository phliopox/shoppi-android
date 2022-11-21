package com.example.app.repository

import com.example.app.model.Category
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CategoryRepository (private val remoteDataSource: CategoryRemoteDataSource){
    //suspend - 코루틴 scope 에서만 실행 되도록 한다.
    //withContext 로 쓰레드를 변경 , 그러나 이러한 쓰레드 분리 과정을 retrofit 에서 자동으로 해줌 ^^...
    suspend fun getCategories():List<Category>{
    /*    withContext(Dispatchers.IO){
            remoteDataSource.getCategories()
        }*/
        return remoteDataSource.getCategories()
    }
}