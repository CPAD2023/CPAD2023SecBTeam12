package com.vyom.movieappjc.data.repository

import com.vyom.movieappjc.data.model.toDomain
import com.vyom.movieappjc.data.network.ApiService
import com.vyom.movieappjc.domain.model.Movie
import com.vyom.movieappjc.domain.repository.MoviesRepo
import com.vyom.movieappjc.utils.SafeApiRequest
import javax.inject.Inject

/**
 * Implementation of the MoviesRepo repository from domain package
 */
class MoviesRepoImpl @Inject constructor(private val apiService: ApiService): MoviesRepo , SafeApiRequest(){
    override suspend fun getPopularMovies(): List<Movie> {
        val response = safeApiRequest { apiService.getPopularMovies(page = 1) }
        return response.results?.toDomain()!!
    }

    override suspend fun getTopMovies(): List<Movie> {
        val response = safeApiRequest { apiService.getTopMovies(page = 1) }
        return response.results?.toDomain()!!
    }

    override suspend fun getUpcomingMovies(): List<Movie> {
        val response = safeApiRequest { apiService.getUpcomingMovies(page = 1) }
        return response.results?.toDomain()!!
    }
}