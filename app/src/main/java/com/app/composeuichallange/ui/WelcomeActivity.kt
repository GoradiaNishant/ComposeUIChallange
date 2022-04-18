/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.app.composeuichallange.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.composeuichallange.theme.MyTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.ui.platform.LocalContext
import androidx.core.view.WindowCompat
import com.app.composeuichallange.R


class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    val context = LocalContext.current
    Scaffold(modifier = Modifier.fillMaxSize()) {
        Image(modifier = Modifier.fillMaxSize(), painter = painterResource(id = R.drawable.ic_welcome), contentDescription = null, contentScale = ContentScale.FillBounds)
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)) {

            //logo
            Image(painter = painterResource(id = R.drawable.ic_logo), contentDescription = null, contentScale = ContentScale.FillBounds)

            //button for signup (pTop-32),(d-72,)
            Button(
                shape = RoundedCornerShape(
                    topStart = 16.dp,
                    topEnd = 16.dp,
                    bottomStart = 16.dp,
                    bottomEnd = 16.dp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(top = 32.dp,),

                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primary,
                    contentColor = Color.Red),
                onClick = {

                }) {

                Text(color = MaterialTheme.colors.onPrimary, text = "SIGN UP", style = MaterialTheme.typography.button)

            }

            //login button
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
                    .height(72.dp)
                    .padding(top = 8.dp,),

                onClick = {
                    context.startActivity(Intent(context, LoginActivity::class.java))
                }) {

                Text(color = MaterialTheme.colors.onSecondary, text = "LOG IN", style = MaterialTheme.typography.button)

            }
        }
    }
}


@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
