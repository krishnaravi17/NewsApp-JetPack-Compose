package com.demo.newsapp.repository

import com.demo.newsapp.data.datasource.NewsDataSource
import com.demo.newsapp.data.entity.NewsResponse
import com.demo.utilities.ResourceState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsDataSource: NewsDataSource
) {


    suspend fun getNewsHeadLine(country: String): Flow<ResourceState<NewsResponse>> {
        return flow {
            emit(ResourceState.Loading())

            val response = newsDataSource.getNewsHeadline(country)

            if (response.isSuccessful && response.body() != null) {
                emit(ResourceState.Success(response.body()!!))
            } else {
                emit(ResourceState.Error("Error in fetching data!"))
            }

        }.catch { e -> emit(ResourceState.Error(e?.localizedMessage ?: "Some thing went wrong!")) }
    }

}