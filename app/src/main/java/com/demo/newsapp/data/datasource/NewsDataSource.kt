package com.demo.newsapp.data.datasource

import com.demo.newsapp.data.entity.NewsResponse
import retrofit2.Response

interface NewsDataSource {

    suspend fun getNewsHeadline(country: String): Response<NewsResponse>

}