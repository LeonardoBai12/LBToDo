package io.lb.wsproject.feature_login.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import io.lb.wsproject.R
import io.lb.wsproject.ui.widgets.DefaultInputText
import io.lb.wsproject.ui.widgets.DefaultTextButton

@ExperimentalComposeUiApi
@ExperimentalMaterial3Api
@Composable
fun LoginScreen(navController: NavHostController) {
    val context = LocalContext.current
    val email = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp),
        color = MaterialTheme.colorScheme.background,
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(vertical = 24.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Insira seus dados",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )

            SignInTextFields(email, password)
            LoginButtons()
        }
    }
}

@Composable
private fun LoginButtons() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DefaultTextButton(
            modifier = Modifier.padding(horizontal = 72.dp, vertical = 16.dp),
            text = "Entrar",
            onClick = {

            },
        )
        DefaultTextButton(
            modifier = Modifier.padding(horizontal = 72.dp)
                .shadow(2.dp, shape = RoundedCornerShape(36.dp)),
            text = "Entrar com Google",
            icon = painterResource(id = R.drawable.ic_google),
            containerColor = Color.White,
            contentColor = Color.DarkGray,
            onClick = {

            },
        )
    }
}

@ExperimentalComposeUiApi
@Composable
private fun SignInTextFields(
    email: MutableState<String>,
    password: MutableState<String>
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DefaultInputText(
            modifier = Modifier.padding(8.dp),
            text = email.value,
            icon = {
                Icon(
                    Icons.Default.Email,
                    contentDescription = "LockIcon"
                )
            },
            label = "E-mail",
            onValueChange = {
                email.value = it
            }
        )

        DefaultInputText(
            modifier = Modifier.padding(8.dp),
            text = password.value,
            icon = {
                Icon(
                    Icons.Default.Lock,
                    contentDescription = "LockIcon"
                )
            },
            label = "Password",
            keyboardType = KeyboardType.Password,
            onValueChange = {
                password.value = it
            }
        )
    }
}