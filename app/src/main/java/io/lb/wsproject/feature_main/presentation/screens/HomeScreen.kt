package io.lb.wsproject.feature_main.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import io.lb.wsproject.feature_main.presentation.navigation.MainScreens
import io.lb.wsproject.feature_main.presentation.widgets.NewTaskBottomSheetContent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
@ExperimentalMaterialApi
@Composable
fun HomeScreen(navController: NavHostController) {
    val selectedCategory = remember {
        mutableStateOf("")
    }

    val bottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = {
            if (it == ModalBottomSheetValue.Hidden) {
                selectedCategory.value = ""
            }
            true
        }
    )
    val coroutineScope = rememberCoroutineScope()

    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetShape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp),
        sheetBackgroundColor = MaterialTheme.colorScheme.surface,
        sheetContentColor = MaterialTheme.colorScheme.onSurface,
        sheetContent = {
            NewTaskBottomSheetContent(selectedCategory) {
                navController.navigate(MainScreens.TaskScreen.name + "/$selectedCategory")
                coroutineScope.launch {
                    bottomSheetState.hide()
                }
            }
        },
    ) {
        HomeScaffold(coroutineScope, bottomSheetState)
    }
}

@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@Composable
private fun HomeScaffold(
    coroutineScope: CoroutineScope,
    bottomSheetState: ModalBottomSheetState
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    coroutineScope.launch {
                        bottomSheetState.show()
                    }
                },
            ) {
                Icon(Icons.Default.Add, contentDescription = "HomeFAB")
            }
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
        }
    }
}