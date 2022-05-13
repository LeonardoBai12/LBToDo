package io.lb.wsproject.feature_main.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import io.lb.wsproject.core.CategoryProvider
import io.lb.wsproject.feature_main.presentation.widgets.IconButtonTextWidget
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun HomeScreen(navController: NavHostController) {
    val bottomSheetScaffoldState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden
    )
    val coroutineScope = rememberCoroutineScope()

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
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(vertical = 24.dp),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Escolha uma atividade",
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )

                    LazyVerticalGrid(
                        modifier = Modifier.padding(24.dp),
                        columns = GridCells.Adaptive(88.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(CategoryProvider.categories) {
                            IconButtonTextWidget(
                                text = it.text,
                                painterId = it.painterId
                            ) {

                            }
                        }
                    }
                }
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