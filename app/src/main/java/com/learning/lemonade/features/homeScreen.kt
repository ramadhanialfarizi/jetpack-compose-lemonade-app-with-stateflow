package com.learning.lemonade.features

import android.annotation.SuppressLint
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.learning.lemonade.features.controller.HomeScreenController
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel


class HomeScreen : ComponentActivity(){
//    private val homeScreenController : HomeScreenController by ViewModel()
    @SuppressLint("SuspiciousIndentation")
    @Composable
    fun HomeScreenApp(modifier: Modifier = Modifier, viewModel: HomeScreenController = viewModel()) {
    val imagesResult by viewModel.imagesResult.collectAsState()
    val titleResult by viewModel.titleResult.collectAsState()
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(painter = painterResource(imagesResult), contentDescription = "diceRoll")
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = titleResult)
            Spacer(modifier = Modifier.height(60.dp))
            Button(
                onClick = {
                   viewModel.onTapImage()
                },
            ) {
                Text(text = "Next Step")
            }
        }
    }
}