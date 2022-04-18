package com.app.composeuichallange.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.app.composeuichallange.R
import com.app.composeuichallange.theme.MyTheme


class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            MyTheme {
                    LoginUI()
            }
        }
    }
}

@Composable
fun LoginUI() {
    val context = LocalContext.current
    Scaffold(modifier = Modifier.fillMaxSize()) {
        Image(modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.ic_login), contentDescription = null, contentScale = ContentScale.FillBounds)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .fillMaxHeight()
                .padding(16.dp)) {

            Text(
                modifier = Modifier
                    .padding(top = 184.dp, bottom = 32.dp),
                color = MaterialTheme.colors.primary, text = "LOG IN", style = MaterialTheme.typography.h1)

            val localFocusManager = LocalFocusManager.current

            var email by remember { mutableStateOf("") }

            TextField(
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next,
                ),
                keyboardActions = KeyboardActions(
                    onNext = {
                        localFocusManager.moveFocus(FocusDirection.Down)
                    }
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(bottom = 8.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.surface,
                    unfocusedIndicatorColor = MaterialTheme.colors.onBackground,
                    textColor = MaterialTheme.colors.onBackground,
                    unfocusedLabelColor = MaterialTheme.colors.onBackground,
                    placeholderColor = MaterialTheme.colors.primary
                ),
                textStyle = MaterialTheme.typography.body1,
                value = email,
                label = { Text("Email Address") },
                onValueChange = { email = it })

            var password by remember { mutableStateOf("") }

            TextField(
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        localFocusManager.clearFocus()
                    }
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(bottom = 8.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.surface,
                    unfocusedIndicatorColor = MaterialTheme.colors.onBackground,
                    unfocusedLabelColor = MaterialTheme.colors.onBackground,
                    textColor = MaterialTheme.colors.onBackground,
                    placeholderColor = MaterialTheme.colors.primary
                ),
                textStyle = MaterialTheme.typography.body1,
                value = password,
                label = {Text("Password")},
                onValueChange = { password = it })

            Button(
                shape = RoundedCornerShape(
                    topStart = 16.dp,
                    topEnd = 16.dp,
                    bottomStart = 16.dp,
                    bottomEnd = 16.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.secondary,
                    contentColor = Color.Red),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(72.dp),

                onClick = {
                    context.startActivity(Intent(context, Dashboard::class.java))
                }) {

                Text(color = MaterialTheme.colors.onSecondary, text = "LOG IN", style = MaterialTheme.typography.button)

            }


            Row( modifier = Modifier
                .padding(top = 32.dp),
            ) {
                Text(color = MaterialTheme.colors.primary, text = "Don't have an account? ", style = MaterialTheme.typography.body1)
                Text(color = MaterialTheme.colors.primary, text = "Sign up", style = MaterialTheme.typography.body1, textDecoration = TextDecoration.Underline)
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyTheme {
        LoginUI()
    }
}