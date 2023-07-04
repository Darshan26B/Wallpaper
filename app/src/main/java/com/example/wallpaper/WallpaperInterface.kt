package com.example.wallpaper

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface WallpaperInterface {

    @GET("search")

    fun getWP(
        @Header("Authorization")auth:String,
    @Query("query")query: String
    ):Call<WallpaperModel>
}