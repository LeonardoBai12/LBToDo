package io.lb.wsproject.feature_login.presentation.navigation

enum class LoginScreens {
    LoginHomeScreen,
    LoginScreen,
    SignInScreen;
    companion object {
        fun fromRoute(route: String?): LoginScreens
                = when (route?.substringBefore("/")) {
            LoginHomeScreen.name -> LoginHomeScreen
            LoginScreen.name -> LoginScreen
            SignInScreen.name -> SignInScreen
            null -> LoginHomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}