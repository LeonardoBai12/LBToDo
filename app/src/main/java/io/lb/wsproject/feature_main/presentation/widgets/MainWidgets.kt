package io.lb.wsproject.feature_main.presentation.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import io.lb.wsproject.ui.widgets.DefaultIcon
import io.lb.wsproject.ui.widgets.DefaultIconButton

@Composable
fun IconButtonTextWidget(
    text: String,
    painterId: Int,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        DefaultIconButton(
            modifier = Modifier.size(48.dp),
            iconModifier = Modifier.fillMaxSize(0.7f),
            painter = painterResource(id = painterId),
            contentDescription = "${text}Icon",
            shape = RoundedCornerShape(16.dp),
            onClick = onClick
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = text, color = MaterialTheme.colorScheme.onPrimaryContainer)
    }
}