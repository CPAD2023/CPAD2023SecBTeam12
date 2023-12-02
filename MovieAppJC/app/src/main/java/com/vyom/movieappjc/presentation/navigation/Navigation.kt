package com.vyom.movieappjc.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vyom.movieappjc.presentation.screens.Home
import com.vyom.movieappjc.presentation.screens.MovieDetailScreen

/**
 * Consists of specifications of Navigation routes
 */
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Home.route){
        composable(Screen.Home.route){
            Home(navController)
        }
        composable(Screen.MovieDetailScreen.route){
            val title = it.arguments?.getString("title")
            val overview = it.arguments?.getString("overview")
            val id = it.arguments?.getString("id")
            val poster = it.arguments?.getString("poster")
            val background = it.arguments?.getString("background")
            val rating = it.arguments?.getString("rating")
            MovieDetailScreen(title = title, overview = overview, id = id, poster = poster, background = background, rating = rating)
        }
    }
}

