package com.demo.newsapp.data.api

import com.demo.newsapp.data.entity.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v2/top-headlines")
    suspend fun getNewsHeadline(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String = "f2a4a6a9281b4d9ca24df5285489880c"
    ) : retrofit2.Response<NewsResponse>
}