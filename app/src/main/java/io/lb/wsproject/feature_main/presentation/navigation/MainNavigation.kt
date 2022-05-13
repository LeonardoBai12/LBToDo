package io.lb.wsproject.feature_main.presentation.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.lb.wsproject.feature_main.presentation.screens.ActivityScreen
import io.lb.wsproject.feature_main.presentation.screens.HomeScreen
import io.lb.wsproject.feature_main.presentation.screens.TaskScreen

@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MainScreens.HomeScreen.name
    ) {
        composable(MainScreens.HomeScreen.name){
            HomeScreen(navController = navController)
        }
        composable(MainScreens.TaskScreen.name){
            TaskScreen(navController = navController)
        }
        composable(MainScreens.ActivityScreen.name) {
            ActivityScreen(navController = navController)
        }
    }
}