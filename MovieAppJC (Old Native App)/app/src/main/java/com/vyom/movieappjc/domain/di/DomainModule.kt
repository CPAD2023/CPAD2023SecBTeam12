package com.vyom.movieappjc.domain.di

import com.vyom.movieappjc.data.network.ApiService
import com.vyom.movieappjc.data.repository.MoviesRepoImpl
import com.vyom.movieappjc.domain.repository.MoviesRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {
    @Provides
    fun provideMoviesRepo(apiService: ApiService): MoviesRepo{
        return MoviesRepoImpl(apiService = apiService )
    }
}