package com.example.app.ui.common

import androidx.lifecycle.Observer

/**
 * https://github.com/android/architecture-samples/blob/dev-dagger/app/src/main/java/com/example/android/architecture/blueprints/todoapp/Event.kt
 * 한번 소비한 데이터는 다시 사용할 수 없도록 구분하는 역할의 클래스
 */
class Event<T>(private val content : T) {

    private var hasBeenHandled = false
    fun getContentIfNotHandled():T?{
        return if(hasBeenHandled){
            null
        }else{
            hasBeenHandled =true
            content
        }
    }
}

class EventObserver<T>(private val onEventUnhandledContent:(T) ->Unit) : Observer<Event<T>>{
    override fun onChanged(event: Event<T>?) {
        event?.getContentIfNotHandled()?.let{
            onEventUnhandledContent(it)
        }
    }

}