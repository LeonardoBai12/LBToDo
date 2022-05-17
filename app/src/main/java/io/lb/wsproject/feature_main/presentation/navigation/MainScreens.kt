package io.lb.wsproject.feature_main.presentation.navigation

enum class MainScreens {
    HomeScreen,
    TaskScreen;
    companion object {
        fun fromRoute(route: String?): MainScreens
                = when (route?.substringBefore("/")) {
            HomeScreen.name -> HomeScreen
            TaskScreen.name -> TaskScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}