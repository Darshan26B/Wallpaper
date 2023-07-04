package com.example.wallpaper

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WallpaperClient {

    companion object {

        var BASE_URL = "https://api.pexels.com/v1/"
        var retrofit: Retrofit? = null

        fun getWPClient(): Retrofit? {
            if (retrofit==null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            }

            return retrofit
        }

    }
}