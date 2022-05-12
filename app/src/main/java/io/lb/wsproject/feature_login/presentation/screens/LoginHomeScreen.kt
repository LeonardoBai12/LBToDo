package io.lb.wsproject.feature_login.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import io.lb.wsproject.feature_login.presentation.navigation.LoginScreens
import io.lb.wsproject.ui.widgets.DefaultTextButton

@ExperimentalComposeUiApi
@ExperimentalMaterial3Api
@Composable
fun LoginHomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(72.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DefaultTextButton(
            text = "Já tenho um cadastro",
            onClick = {
                navController.navigate(route = LoginScreens.LoginScreen.name)
            },
        )

        Spacer(modifier = Modifier.height(24.dp))

        DefaultTextButton(
            text = "Cadastrar-se",
            containerColor = MaterialTheme.colorScheme.onPrimary,
            contentColor = MaterialTheme.colorScheme.primary,
            onClick = {
                navController.navigate(route = LoginScreens.SignInScreen.name)
            },
        )
    }
}