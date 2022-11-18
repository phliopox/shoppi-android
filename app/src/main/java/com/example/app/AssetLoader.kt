package com.example.app

import android.content.Context

class AssetLoader(private val context: Context) {
    fun getJsonString(fileName: String) : String? {
        return kotlin.runCatching {
            loadAsset(fileName)
        }.getOrNull()

    }

    private fun loadAsset(fileName : String):String{
        return context.assets.open(fileName).use { inputStream ->
            val size = inputStream.available()
            val bytes = ByteArray(size)
            inputStream.read(bytes)
            String(bytes)
            // Log.d("dd",homeData)
        }
    }
}