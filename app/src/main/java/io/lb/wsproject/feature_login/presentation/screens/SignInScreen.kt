package io.lb.wsproject.feature_login.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import io.lb.wsproject.ui.widgets.DefaultInputText
import io.lb.wsproject.ui.widgets.DefaultTextButton

@ExperimentalComposeUiApi
@Composable
fun SignInScreen(navController: NavHostController) {
    val context = LocalContext.current
    val email = remember {
        mutableStateOf("")
    }
    val name = remember {
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
                text = "Nova conta",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )

            SignInTextFields(email, name, password)

            DefaultTextButton(
                modifier = Modifier.padding(horizontal = 72.dp, vertical = 16.dp),
                text = "Criar conta",
                onClick = {

                },
            )
        }
    }
}

@ExperimentalComposeUiApi
@Composable
private fun SignInTextFields(
    email: MutableState<String>,
    name: MutableState<String>,
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
            text = name.value,
            icon = {
                Icon(
                    Icons.Default.AccountBox,
                    contentDescription = "AccountIcon"
                )
            },
            label = "Nome completo",
            onValueChange = {
                name.value = it
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