package com.vyom.movieappjc.domain.use_case

import com.vyom.movieappjc.domain.model.Movie
import com.vyom.movieappjc.domain.repository.MoviesRepo
import com.vyom.movieappjc.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Fetches the upcoming movies
 * @param moviesRepo Passed via construction injection
 */
class GetUpcomingMoviesUseCase @Inject constructor(private val moviesRepo: MoviesRepo) {
    operator fun invoke(): Flow<Resource<List<Movie>>> = flow {
        emit(Resource.Loading(""))
        try {
            emit(Resource.Success(moviesRepo.getUpcomingMovies()))
        } catch (e: Exception) {
            emit(Resource.Error(e.message))
        }
    }
}