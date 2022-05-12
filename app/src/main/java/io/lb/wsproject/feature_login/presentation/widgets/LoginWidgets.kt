package io.lb.wsproject.feature_login.presentation.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.lb.wsproject.R
import io.lb.wsproject.ui.widgets.WSLogoIcon

@Composable
fun HomeLoginBackground() {
    Image(
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop,
        painter = painterResource(id = R.drawable.tools_picture),
        contentDescription = "LoginHomeScreenBackground",
    )
}

@Composable
fun HomeLoginHeader() {
    Column(modifier = Modifier.padding(48.dp)) {
        WSLogoIcon()
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "WS Project",
            fontSize = 40.sp,
            color = Color.White
        )
    }
}