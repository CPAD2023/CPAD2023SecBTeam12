package com.vyom.movieappjc.domain.repository

import com.vyom.movieappjc.domain.model.Movie

interface MoviesRepo {
    suspend fun getPopularMovies(): List<Movie>
    suspend fun getTopMovies(): List<Movie>
    suspend fun getUpcomingMovies(): List<Movie>
}