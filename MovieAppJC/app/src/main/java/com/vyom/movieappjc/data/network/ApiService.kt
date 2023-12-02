package com.vyom.movieappjc.data.network

import com.vyom.movieappjc.data.model.MoviesDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    /**
     * Get API request for popular movies
     * @param apiKey - API Key for authentication
     * @param page - Results of corresponding page number
     */
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = "946e1f0029e261b6d6fbc63e394542ed",
        @Query("page") page: Int
    ): Response<MoviesDTO>

    /**
     * Get API request for top movies
     * @param apiKey - API Key for authentication
     * @param page - Results of corresponding page number
     */
    @GET("movie/top_rated")
    suspend fun getTopMovies(
        @Query("api_key") apiKey: String = "946e1f0029e261b6d6fbc63e394542ed",
        @Query("page") page: Int
    ): Response<MoviesDTO>

    /**
     * Get API request for upcoming movies
     * @param apiKey - API Key for authentication
     * @param page - Results of corresponding page number
     */
    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("api_key") apiKey: String = "946e1f0029e261b6d6fbc63e394542ed",
        @Query("page") page: Int
    ): Response<MoviesDTO>
}