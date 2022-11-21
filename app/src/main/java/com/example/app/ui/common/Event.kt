package com.example.app.ui.common

import androidx.lifecycle.Observer

/**
 * https://github.com/android/architecture-samples/blob/dev-dagger/app/src/main/java/com/example/android/architecture/blueprints/todoapp/Event.kt
 */
class Event<T>(private val content : T) {

    private var hasBeenHandled = false
    fun getContentIgNotHandled():T?{
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
        event?.getContentIgNotHandled()?.let{
            onEventUnhandledContent(it)
        }
    }

}