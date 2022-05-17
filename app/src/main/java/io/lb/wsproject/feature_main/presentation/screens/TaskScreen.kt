package io.lb.wsproject.feature_main.presentation.screens

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import io.lb.wsproject.R
import io.lb.wsproject.ui.widgets.DefaultFilledTextField
import io.lb.wsproject.ui.widgets.DefaultTextButton
import io.lb.wsproject.util.datePicker
import io.lb.wsproject.util.timePicker

@ExperimentalComposeUiApi
@Composable
fun TaskScreen(
    navController: NavHostController,
    category: String
) {
    val title = remember {
        mutableStateOf("")
    }

    val description = remember {
        mutableStateOf("")
    }

    val date = remember {
        mutableStateOf("")
    }

    val time = remember {
        mutableStateOf("")
    }

    Text(text = category, fontSize = 48.sp)
    Scaffold(
        backgroundColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.onBackground,
        topBar = {
            TopAppBar(
                backgroundColor = Color.Transparent,
                contentColor = MaterialTheme.colorScheme.onBackground,
                elevation = 0.dp,
            ) {
                Row(
                    modifier = Modifier.padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription ="Arrow Back",
                        )
                    }
                }
            }
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Nova tarefa",
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold
            )

            DefaultFilledTextField(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                text = title,
                label = "Título",
            )

            DefaultFilledTextField(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                text = description,
                isSingleLined = false,
                label = "Descrição",
            )

            DateAndTimePickers(date, time)

            DefaultTextButton(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 72.dp, vertical = 16.dp),
                text = "Finalizar"
            ) {
                navController.popBackStack()
            }
        }
    }
}

@ExperimentalComposeUiApi
@Composable
private fun DateAndTimePickers(
    date: MutableState<String>,
    time: MutableState<String>,
) {
    val context = LocalContext.current
    val datePicker = datePicker(context, date)
    val timePicker = timePicker(context, time)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        DefaultFilledTextField(
            modifier = Modifier.fillMaxWidth(0.55f),
            text = date,
            isSingleLined = false,
            isEnabled = false,
            hasCloseButton = true,
            label = "Prazo de entrega",
            icon = {
                Icon(
                    Icons.Default.DateRange,
                    modifier = Modifier.clickable {
                        datePicker.show()
                    },
                    contentDescription = "dateIcon"
                )
            },
        )
        Spacer(modifier = Modifier.width(8.dp))
        DefaultFilledTextField(
            modifier = Modifier.fillMaxWidth(),
            text = time,
            isSingleLined = false,
            isEnabled = false,
            hasCloseButton = true,
            label = "",
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_clock),
                    modifier = Modifier.clickable {
                        timePicker.show()
                    },
                    contentDescription = "dateIcon"
                )
            },
        )
    }
}

