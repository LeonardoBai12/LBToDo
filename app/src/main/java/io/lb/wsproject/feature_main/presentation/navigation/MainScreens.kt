package io.lb.wsproject.feature_main.presentation.navigation

enum class MainScreens {
    HomeScreen,
    TaskScreen,
    ActivityScreen;
    companion object {
        fun fromRoute(route: String?): MainScreens
                = when (route?.substringBefore("/")) {
            HomeScreen.name -> HomeScreen
            TaskScreen.name -> TaskScreen
            ActivityScreen.name -> ActivityScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}