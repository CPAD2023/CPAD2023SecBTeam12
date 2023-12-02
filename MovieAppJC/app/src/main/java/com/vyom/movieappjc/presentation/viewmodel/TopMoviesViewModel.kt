package com.vyom.movieappjc.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vyom.movieappjc.domain.use_case.GetTopMoviesUseCase
import com.vyom.movieappjc.presentation.HomeStateHolder
import com.vyom.movieappjc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TopMoviesViewModel @Inject constructor(private val getTopMoviesUseCase: GetTopMoviesUseCase): ViewModel() {
    val movies = mutableStateOf(HomeStateHolder())

    init {
        getTopMovie()
    }

    fun getTopMovie(){
        getTopMoviesUseCase().onEach {
            when(it){
                is Resource.Loading->{
                    movies.value = HomeStateHolder(isLoading = true)
                }
                is Resource.Success->{
                    movies.value = HomeStateHolder(data = it.data)
                }
                is Resource.Error->{
                    movies.value = HomeStateHolder(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }
}