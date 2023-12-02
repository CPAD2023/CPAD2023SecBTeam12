package com.vyom.movieappjc.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.vyom.movieappjc.ui.theme.*

/**
 * @param title Title of the movie
 * @param overview Brief summary of the app
 * @param id Unique ID of the movie
 * @param poster URL of the poster image of the movie
 * @param background URL of the background image of the movie
 * @param rating Rating of the movie (out of 10.0)
 */
@Composable
fun MovieDetailScreen(title: String?, overview: String?, id: String?, poster: String?, background: String?, rating: String?) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Box(modifier = Modifier.fillMaxWidth()){
                Image(
                    painter = rememberAsyncImagePainter("https://image.tmdb.org/t/p/w1280/$background"),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
                Image(
                    painter = rememberAsyncImagePainter("https://image.tmdb.org/t/p/w342/$poster"),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 125.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .align(Alignment.Center)

                )
            }
            Text(
                text = title!!,
                style = TextStyle(fontSize = FLarge, fontWeight = FontWeight.Bold, color = Purple200, textAlign = TextAlign.Center)
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Rating: $rating/10.0",
                style = TextStyle(textAlign = TextAlign.Center, fontSize = FMedium, fontWeight = FontWeight.SemiBold, color = Yellow500),
                modifier = Modifier
                    .padding(horizontal = 7.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = overview!!,
                modifier = Modifier
                    .padding(horizontal = 20.dp),
                style = TextStyle(textAlign = TextAlign.Center, fontSize = FSmall)
            )
        }

    }
}
