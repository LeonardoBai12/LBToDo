package io.lb.wsproject.feature_login.presentation.screens

import android.content.Context
import android.content.Intent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
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
import io.lb.wsproject.feature_main.presentation.MainActivity
import io.lb.wsproject.ui.widgets.DefaultTextField
import io.lb.wsproject.ui.widgets.DefaultTextButton

@ExperimentalMaterialApi
@ExperimentalAnimationApi
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
            LoginButtons(context)
        }
    }
}

@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
private fun LoginButtons(context: Context) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DefaultTextButton(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 72.dp, vertical = 16.dp),
            text = "Entrar",
            onClick = {
                context.startActivity(Intent(context, MainActivity::class.java))
            },
        )
        DefaultTextButton(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 72.dp)
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
        DefaultTextField(
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

        DefaultTextField(
            modifier = Modifier.padding(8.dp),
            text = password.value,
            icon = {
                Icon(
                    Icons.Default.Lock,
                    contentDescription = "LockIcon"
                )
            },
            label = "Senha",
            keyboardType = KeyboardType.Password,
            onValueChange = {
                password.value = it
            }
        )
    }
}