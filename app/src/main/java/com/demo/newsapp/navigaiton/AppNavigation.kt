package com.demo.newsapp.navigaiton

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.demo.newsapp.screens.HomeScreen
import com.demo.newsapp.viewmodel.NewsViewModel


@Composable
fun AppNavigationGraph( modifier: Modifier = Modifier){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.HOME_SCREEN ){
        composable(Routes.HOME_SCREEN){
            HomeScreen()
        }
    }

}