package io.lb.wsproject.feature_main.presentation.widgets

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.lb.wsproject.util.CategoryProvider
import io.lb.wsproject.ui.widgets.DefaultIconButton
import io.lb.wsproject.ui.widgets.DefaultTextButton

@Composable
fun NewTaskBottomSheetContent(selectedCategory: MutableState<String>) {
    Column(
        modifier = Modifier.fillMaxWidth()
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
                    painterId = it.painterId,
                    selectedCategory = selectedCategory
                )
            }
        }

        DefaultTextButton(
            modifier = Modifier.width(200.dp),
            text = "Criar nova tarefa",
            enabled = selectedCategory.value.isNotEmpty()
        ) {

        }
    }
}

@Composable
fun IconButtonTextWidget(
    text: String,
    painterId: Int,
    selectedCategory: MutableState<String>,
) {
    Column(
        modifier = Modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        DefaultIconButton(
            modifier = Modifier.takeIf {
                text == selectedCategory.value
            }?.border(
                width = 2.dp,
                shape = RoundedCornerShape(16.dp),
                brush = Brush.horizontalGradient(
                    listOf(
                        Color(0xFFFFB700),
                        Color(0xFFFFDD00),
                        Color(0xFFFFB700)
                    )
                )
            ) ?: Modifier.size(48.dp),
            iconModifier = Modifier.fillMaxSize(0.7f),
            painter = painterResource(id = painterId),
            contentDescription = "${text}Icon",
            shape = RoundedCornerShape(16.dp),
            onClick = {
                selectedCategory.value = text
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = text, color = MaterialTheme.colorScheme.onPrimaryContainer)
    }
}