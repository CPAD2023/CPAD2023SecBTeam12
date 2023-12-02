package com.vyom.movieappjc.domain.model

/**
 * Holds the values that are actually used in the app.
 */
data class Movie(
    val backdropPath: String,
    val id: Int,
    val originalLanguage: String,
    val overview: String,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val voteAverage: Double,
)
