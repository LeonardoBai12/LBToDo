package io.lb.wsproject.ui.widgets

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.lb.wsproject.R

@Composable
fun WSLogoIcon() {
    DefaultIcon(
        modifier = Modifier.size(72.dp),
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "LoginHomeScreenIcon",
    )
}

@Composable
fun DefaultIcon(
    modifier: Modifier = Modifier,
    iconModifier: Modifier = Modifier.fillMaxSize(),
    shape: Shape = RoundedCornerShape(24.dp),
    painter: Painter,
    contentDescription: String,
) {
    Box(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.onPrimary,
                shape = shape
            ),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            modifier = iconModifier,
            painter = painter,
            contentDescription = contentDescription,
            tint = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun DefaultIconButton(
    modifier: Modifier = Modifier,
    iconModifier: Modifier = Modifier.fillMaxSize(),
    shape: Shape = RoundedCornerShape(24.dp),
    painter: Painter,
    contentDescription: String,
    onClick: () -> Unit
) {
    IconButton(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = shape
            ),
        onClick = onClick,
    ) {
        Icon(
            modifier = iconModifier,
            painter = painter,
            contentDescription = contentDescription,
            tint = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Composable
fun DefaultTextButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    icon: Painter? = null,
    containerColor: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = MaterialTheme.colorScheme.onPrimary,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier.height(56.dp),
        enabled = enabled,
        shape = RoundedCornerShape(36.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor,
        ),
        onClick = onClick,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            icon?.let {
                Icon(
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp),
                    painter = it,
                    contentDescription = "SignInButton",
                    tint = Color.Unspecified
                )
            }
            Text(
                text = text,
                fontSize = 18.sp,
                fontWeight = FontWeight.Light
            )
        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun DefaultTextField(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    icon: @Composable (() -> Unit) = {},
    isEnabled: Boolean = true,
    isSingleLined: Boolean = true,
    keyboardType: KeyboardType = KeyboardType.Ascii,
    onValueChange: (String) -> Unit,
    onImeAction: () -> Unit = {},
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(
        modifier = modifier,
        value = text,
        singleLine = isSingleLined,
        leadingIcon = icon,
        enabled = isEnabled,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
        ),
        label = {
            Text(text = label)
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done,
            keyboardType = keyboardType
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                onImeAction.invoke()
                keyboardController?.hide()
            }
        ),
        onValueChange = {
            onValueChange.invoke(it)
        }
    )
}

@ExperimentalComposeUiApi
@Composable
fun DefaultOutlinedTextField(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    icon: @Composable (() -> Unit)? = null,
    isEnabled: Boolean = true,
    isSingleLined: Boolean = true,
    keyboardType: KeyboardType = KeyboardType.Ascii,
    onValueChange: (String) -> Unit,
    onImeAction: () -> Unit = {},
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        modifier = modifier,
        value = text,
        singleLine = isSingleLined,
        leadingIcon = icon,
        enabled = isEnabled,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
        ),
        label = {
            Text(text = label)
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done,
            keyboardType = keyboardType
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                onImeAction.invoke()
                keyboardController?.hide()
            }
        ),
        onValueChange = {
            onValueChange.invoke(it)
        }
    )
}