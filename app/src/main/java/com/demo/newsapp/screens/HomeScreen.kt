package com.demo.newsapp.screens

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.demo.newsapp.components.Loader
import com.demo.newsapp.components.NewsRowComponent
import com.demo.newsapp.viewmodel.NewsViewModel
import com.demo.utilities.ResourceState


// val weatherViewModel = ViewModelProvider(this)[NewsViewModel::class.java]

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    newsViewModel: NewsViewModel = hiltViewModel()
) {

    val newRes by newsViewModel.news.collectAsState()

    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        100//later we will do pagination work
    }

    VerticalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize().padding(8.dp),
        pageSize = PageSize.Fill,
        pageSpacing =  8.dp
        ) {
        page ->
        when (newRes) {
            is ResourceState.Loading -> {
                Log.d("TAG", "Inside Loader")
                Loader()
            }

            is ResourceState.Success -> {

                val response = (newRes as ResourceState.Success).data
                Log.d("TAG", "Inside Success ${response.totalResults}")
                NewsRowComponent(page,response.articles.get(page))
            }

            is ResourceState.Error -> {
                val response = (newRes as ResourceState.Error).error
                Log.d("TAG", "Inside Error ${response.toString()}")
            }
        }
    }





}