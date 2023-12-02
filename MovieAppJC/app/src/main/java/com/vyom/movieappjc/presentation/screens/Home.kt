package com.vyom.movieappjc.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import com.vyom.movieappjc.ui.theme.FLarge
import com.vyom.movieappjc.ui.theme.Purple200
import com.vyom.movieappjc.ui.theme.Purple500

/**
 * Homescreen
 */
@Composable
fun Home(navController: NavHostController){
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = {
                Text(
                    text = "Movies App",
                    style = TextStyle(color = Purple200, fontWeight = FontWeight.ExtraBold, fontSize = FLarge)
                )
            }
        )
        Column(modifier = Modifier.verticalScroll(state = rememberScrollState())) {
            PopComposable(navController)
            TopComposable(navController)
            UpComposable(navController)
        }
    }

}