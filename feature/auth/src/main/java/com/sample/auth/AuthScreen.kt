package com.sample.auth

import android.app.Activity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.haeti.navigation.NavigationUtil

@Composable
fun AuthScreen(
    modifier: Modifier = Modifier,
    text: String,
    navController: NavController
) {
    var data by rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current

    Scaffold() {
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(it),
        ) {
            Column(modifier = modifier.fillMaxSize()) {
                Text(
                    style = MaterialTheme.typography.labelLarge,
                    color = Color.Black,
                    text = text,
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    modifier = modifier
                        .padding(horizontal = 15.dp, vertical = 50.dp)
                        .fillMaxWidth(),
                )
                TextField(
                    value = data,
                    placeholder = { Text(text = "힌트") },
                    label = { Text(text = "라벨") },
                    onValueChange = {
                        data = it
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    modifier = modifier
                        .padding(horizontal = 15.dp, vertical = 20.dp)
                        .fillMaxWidth(),
                )

                Button(
                    onClick = {
                        (context as NavigationUtil).navigateToDrawer(data)
                    },
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                ) {
                    Text(text = "버튼")
                }
            }
        }
    }
}

@Preview
@Composable
private fun preview_AuthScreen() {
    AuthScreen(Modifier, "text", navController = rememberNavController())
}
