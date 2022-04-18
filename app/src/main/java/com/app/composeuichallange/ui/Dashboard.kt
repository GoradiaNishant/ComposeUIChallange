package com.app.composeuichallange.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.CombinedModifier
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.app.composeuichallange.R
import com.app.composeuichallange.sampledata.Message
import com.app.composeuichallange.sampledata.SampleData
import com.app.composeuichallange.theme.MyTheme

class Dashboard : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        setContent {
            MyTheme() {
//                Box(modifier = Modifier.padding(16.dp)) {
                    DashboardUI()
//                }
            }
        }
    }
}

@Composable
fun DashboardUI() {
    val context = LocalContext.current
    Scaffold(
        backgroundColor = MaterialTheme.colors.background,
        bottomBar = {

            BottomNavigation(
                modifier = Modifier.fillMaxWidth(),
                backgroundColor = MaterialTheme.colors.background,
            ) {
                BottomNavigationItem(
                    icon = {
                        Icon(painterResource(id = R.drawable.spa),
                            modifier = Modifier.size(18.dp),
                            tint = MaterialTheme.colors.onBackground,
                            contentDescription = "")
                    },
                    label = { Text(text = "Home") },
                    selectedContentColor = MaterialTheme.colors.onBackground,
                    unselectedContentColor = MaterialTheme.colors.onSurface,
                    alwaysShowLabel = true,
                    selected = false,
                    onClick = {
                        //something to perform
                    }
                )

                BottomNavigationItem(
                    icon = { Icon(painterResource(id = R.drawable.account),
                        modifier = Modifier.size(18.dp),
                        contentDescription = "") },
                    label = { Text(text = "Account") },
                    selectedContentColor = MaterialTheme.colors.onBackground,
                    unselectedContentColor = MaterialTheme.colors.onSurface,
                    alwaysShowLabel = true,
                    selected = false,
                    onClick = {
                        /* Add code later */
                    }
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        floatingActionButton = {
            FloatingActionButton(
                shape = CircleShape,
                onClick = {},
                backgroundColor = MaterialTheme.colors.onBackground,
                contentColor = MaterialTheme.colors.background,
            ) {
                Icon(painter = painterResource(id = R.drawable.play),
                    modifier = Modifier.size(18.dp), contentDescription = "Add icon")
            }}
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(16.dp)) {

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(112.dp)
                    .padding(top = 56.dp),
                colors = TextFieldDefaults.textFieldColors(
                    leadingIconColor = MaterialTheme.colors.onBackground,
                    backgroundColor = MaterialTheme.colors.surface,
                    unfocusedIndicatorColor = MaterialTheme.colors.onBackground,
                    textColor = MaterialTheme.colors.onBackground,
                    placeholderColor = MaterialTheme.colors.primary
                ),
                leadingIcon = {
                    Icon(modifier=Modifier.size(18.dp),
                        painter = painterResource(id = R.drawable.search_icon), contentDescription = "")
                },
                textStyle = MaterialTheme.typography.body1,
                value = "Search", onValueChange = {})


            LazyColumn(){
                item{
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 42.dp),
                        color = MaterialTheme.colors.primary, text = "FAVORITE COLLECTION", style = MaterialTheme.typography.h2)

                    Spacer(modifier = Modifier.height(8.dp))
                    favoriteCollections(SampleData.conversationSample)
                    Spacer(modifier = Modifier.height(8.dp))
                    favoriteCollections(SampleData.conversationSample)

                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 42.dp),
                        color = MaterialTheme.colors.primary, text = "ALIGN YOUR BODY", style = MaterialTheme.typography.h2)

                    alignYourBody(SampleData.conversationSample)

                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 42.dp),
                        color = MaterialTheme.colors.primary, text = "ALIGN YOUR BODY", style = MaterialTheme.typography.h2)

                    alignYourBody(SampleData.conversationSample)

                    Spacer(modifier = Modifier.height(38.dp))
                }
            }

        }
    }
}


@Composable
fun favoriteCollections(messages: List<Message>) {
    LazyRow{
        items(messages) { message ->
            favoriteCollectionCard(message)
        }
    }
}

@Composable
fun alignYourBody(messages: List<Message>) {
    LazyRow{
        items(messages) { message ->
            alignYourBodyCard(message)
        }
    }
}


@Composable
fun favoriteCollectionCard(msg: Message) {
    Surface(
        color = MaterialTheme.colors.surface,
        modifier = Modifier
            .size(height = 56.dp, width = 192.dp)
            .padding(4.dp)
            .clip(
                shape = RoundedCornerShape(
                    topStart = 6.dp,
                    topEnd = 6.dp,
                    bottomStart = 6.dp,
                    bottomEnd = 6.dp
                ),
            )
    ) {
        Row() {
            Image(
                painter = painterResource(R.drawable.sample_img),
                contentDescription = null,
                modifier = Modifier
                    .size(height = 56.dp, width = 45.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(8.dp))
            // We toggle the isExpanded variable when we click on this Column
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.size(width = 140.dp, height = 56.dp)
            ) {
                Text(
                    text = msg.author,
                    color = MaterialTheme.colors.onSurface,
                    style = MaterialTheme.typography.h3
                )
            }
        }
    }
}

@Composable
fun alignYourBodyCard(msg: Message) {
    Column( horizontalAlignment = Alignment.CenterHorizontally,) {
        Image(
            painter = painterResource(R.drawable.sample_img),
            contentDescription = null,
            modifier = Modifier
                .size(88.dp)
                .padding(top = 8.dp, bottom = 8.dp, start = 8.dp, end = 8.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Text(
            modifier = Modifier
                .fillMaxWidth(),
            color = MaterialTheme.colors.primary, text = msg.body, style = MaterialTheme.typography.h3)

    }
}
