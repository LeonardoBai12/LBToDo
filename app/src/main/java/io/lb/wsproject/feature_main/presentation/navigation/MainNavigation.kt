package io.lb.wsproject.feature_main.presentation.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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

        composable(
            route = MainScreens.TaskScreen.name + "/{category}",
            arguments = listOf(
                navArgument(name = "category") {
                    type = NavType.StringType
                }
            )
        ){ backStackEntry ->
            backStackEntry.arguments?.getString("category")?.let {
                TaskScreen(
                    navController = navController,
                    it
                )
            }
        }
    }
}