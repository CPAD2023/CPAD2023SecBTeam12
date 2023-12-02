package com.vyom.movieappjc.data.model

import com.google.gson.annotations.SerializedName
import com.vyom.movieappjc.domain.model.Movie

data class MoviesDTO(
    val page: Int?,
    val results: List<MovieDTO>?,
    @SerializedName("total_pages") val totalPages: Int?,
    val total_results: Int?
)

/**
 * Converts Data Transfer Object to Movie data class
 */
fun List<MovieDTO>.toDomain():List<Movie>{
    return map {
        Movie(
            backdropPath = it.backdropPath?:"",
            id = it.id?:1,
            originalLanguage = it.originalLanguage?:"",
            overview = it.overview?:"",
            posterPath = it.posterPath?:"",
            releaseDate = it.releaseDate?:"",
            title = it.title?:"",
            voteAverage = it.voteAverage?:0.0
        )
    }
}