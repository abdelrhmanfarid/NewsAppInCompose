package com.free.newsapp.presentation.navgraph

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.paging.compose.collectAsLazyPagingItems
import com.free.newsapp.presentation.home.HomeScreen
import com.free.newsapp.presentation.home.HomeViewModel
import com.free.newsapp.presentation.onboarding.OnBoardingScreen
import com.free.newsapp.presentation.onboarding.OnBoardingViewModel
import com.free.newsapp.presentation.search.SearchNewsViewModel
import com.free.newsapp.presentation.search.SearchScreen

@ExperimentalFoundationApi
@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {

        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(
                route = Route.OnBoardingScreen.route
            ) {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(event = viewModel::onEvent)
                // the two are equal
//                    OnBoardingScreen(event = {
//                        viewModel.onEvent(it)
//                    })
            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigationScreen.route
        ) {
            composable(
                route = Route.NewsNavigationScreen.route
            ){
//               val viewModel:HomeViewModel = hiltViewModel()
//                val articles = viewModel.news.collectAsLazyPagingItems()
//                HomeScreen(articles = articles, navigate = {})

                val viewModel:SearchNewsViewModel = hiltViewModel()

                SearchScreen(state = viewModel.state.value, event = viewModel::onEvent, navigate = {})
            }
        }
    }
}