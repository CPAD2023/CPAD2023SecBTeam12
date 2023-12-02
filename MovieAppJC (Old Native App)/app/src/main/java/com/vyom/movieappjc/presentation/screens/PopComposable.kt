package com.vyom.movieappjc.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.vyom.movieappjc.presentation.viewmodel.PopularMoviesViewModel
import com.vyom.movieappjc.ui.theme.Purple500
import com.vyom.movieappjc.ui.theme.Teal200

/**
 * Popular Movies component on the homescreen.
 */
@Composable
fun PopComposable(navController: NavHostController, viewModel: PopularMoviesViewModel = hiltViewModel()){
    val res = viewModel.movies.value

    if (res.isLoading){
        Box(modifier = Modifier.fillMaxSize()){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
    if (res.error.isNotBlank()){
        Box(modifier = Modifier.fillMaxSize()){
            Text(text = res.error, modifier = Modifier.align(Alignment.Center))
        }
    }

    res.data?.let {
        Column {
            Text(
                text = "Popular Movies",
                style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Teal200),
                modifier = Modifier.padding(7.dp)
            )
            LazyRow(modifier = Modifier.padding(7.dp)) {
                items(it) {
                    MovieItem(it, navController)
                }
            }
        }
    }
}

