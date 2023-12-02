package com.vyom.movieappjc.presentation.navigation

/**
 * Contains all the screens that exist in the app.
 * @param route route url passed as a String.
 */
sealed class Screen(val route: String){
    object Home: Screen("home_screen")
    object MovieDetailScreen: Screen("movie_detail_screen/{title}/{overview}/{id}/{poster}/{background}/{rating}")
}
