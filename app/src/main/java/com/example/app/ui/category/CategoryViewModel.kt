package com.example.app.ui.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.model.Category
import com.example.app.repository.CategoryRepository
import kotlinx.coroutines.launch

class CategoryViewModel(private val categoryRepository: CategoryRepository) : ViewModel() {


    private val _items = MutableLiveData<List<Category>> ()
    val items :LiveData<List<Category>> = _items

    init{
        loadCategory()
    }

    private fun loadCategory() {
        //repository 에 데이터 요청 -> 네트워크 통신 -> ui thread(메인 스레드) 에서 요청하면 안된다. ->repository 에서 스레드 분리 후 -> 뷰모델에서 코루틴 스코프 사용!
        viewModelScope.launch {
            val categories = categoryRepository.getCategories()
            _items.value = categories

        }
    }
}