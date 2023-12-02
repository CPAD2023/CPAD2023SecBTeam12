package com.vyom.movieappjc.presentation

import com.vyom.movieappjc.domain.model.Movie

data class HomeStateHolder(
    val isLoading: Boolean=false,
    val data: List<Movie>?=null,
    val error: String=""
)
