package io.lb.wsproject.feature_main.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import io.lb.wsproject.feature_main.presentation.widgets.NewTaskBottomSheetContent
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun HomeScreen(navController: NavHostController) {
    val bottomSheetScaffoldState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden
    )
    val coroutineScope = rememberCoroutineScope()

    val selectedCategory = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ModalBottomSheetLayout(
            sheetState = bottomSheetScaffoldState,
            sheetShape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp),
            sheetBackgroundColor = MaterialTheme.colorScheme.surface,
            sheetContentColor = MaterialTheme.colorScheme.onSurface,
            sheetContent = {
                NewTaskBottomSheetContent(selectedCategory)
            },
        ) {
            Button(onClick = {
                coroutineScope.launch {
                    bottomSheetScaffoldState.show()
                }
            }) {
                Text(text = "Expand/Collapse Bottom Sheet")
            }
        }
    }
}