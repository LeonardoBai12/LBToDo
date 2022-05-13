package io.lb.wsproject.feature_login.presentation.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.lb.wsproject.feature_login.presentation.screens.LoginHomeScreen
import io.lb.wsproject.feature_login.presentation.screens.LoginScreen
import io.lb.wsproject.feature_login.presentation.screens.SignInScreen

@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun LoginNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = LoginScreens.LoginHomeScreen.name
    ) {
        composable(LoginScreens.LoginHomeScreen.name){
            LoginHomeScreen(navController = navController)
        }
        composable(LoginScreens.LoginScreen.name){
            LoginScreen(navController = navController)
        }
        composable(LoginScreens.SignInScreen.name) {
            SignInScreen(navController = navController)
        }
    }
}