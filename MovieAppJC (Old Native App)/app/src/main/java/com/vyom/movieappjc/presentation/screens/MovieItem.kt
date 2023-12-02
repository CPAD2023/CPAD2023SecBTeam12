package com.vyom.movieappjc.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.vyom.movieappjc.domain.model.Movie
import com.vyom.movieappjc.ui.theme.FMedium
import com.vyom.movieappjc.ui.theme.Purple200
import com.vyom.movieappjc.ui.theme.Purple500
import com.vyom.movieappjc.ui.theme.Teal200

/**
 * A single component of movie which consists of the Poster and Title
 */
@Composable
fun MovieItem(it: Movie, navController: NavHostController) {
    Column(modifier = Modifier.clickable(
        onClick = {
//            navController.navigate("movie_detail_screen/${it.title}/${it.overview}/${it.id}/${it.posterPath}/${it.backdropPath}/${it.voteAverage}")
            navController.navigate("movie_detail_screen/${it.title}/${it.overview}/${it.id}/${it.posterPath.drop(1)}/${it.backdropPath.drop(1)}/${it.voteAverage}")
        }
    )) {
        Image(
            painter = rememberAsyncImagePainter("https://image.tmdb.org/t/p/w342${it.posterPath}"),
            contentDescription = null,
            modifier = Modifier
                .height(250.dp)
                .width(170.dp)
                .clip(RoundedCornerShape(10.dp))
        )
        Text(
            text = it.title,
            style = TextStyle(color = Purple200, fontWeight = FontWeight.SemiBold, fontSize = FMedium),
            modifier = Modifier
                .padding(3.dp)
                .width(170.dp)
        )
    }
}
