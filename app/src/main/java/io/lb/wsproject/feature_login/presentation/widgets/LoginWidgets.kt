package io.lb.wsproject.feature_login.presentation.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.lb.wsproject.R
import io.lb.wsproject.ui.widgets.DefaultIcon
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

@ExperimentalMaterial3Api
@Composable
fun TaskCard(onClick: (String) -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(0.5f)
        ),
        onClick = { },
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            DefaultIcon(
                modifier = Modifier.size(48.dp),
                iconModifier = Modifier.fillMaxSize(0.7f),
                shape = RoundedCornerShape(16.dp),
                containerColor = MaterialTheme.colorScheme.background.copy(0.9f),
                painter = painterResource(id = R.drawable.ic_home),
                contentDescription = "", // Nome da task
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column {
                Text(
                    text = "Tarefa registrada",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp
                )
                Text(
                    text = "12/12/2020 12:20",
                    fontSize = 12.sp
                )
            }

        }
    }
}