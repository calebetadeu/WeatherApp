package com.example.weatherapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.screens.MainScreen
import com.example.weatherapp.screens.WeatherSplashScreen

@Composable
fun WeatherNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = WeatherScreens.SplashScreen.name) {
        composable(WeatherScreens.SplashScreen.name) {
            WeatherSplashScreen(onNavigateToHomeScreen = { navController.navigate(WeatherScreens.MainScreen.name) })
        }
        composable(WeatherScreens.MainScreen.name) {
            MainScreen()
        }
    }
}

