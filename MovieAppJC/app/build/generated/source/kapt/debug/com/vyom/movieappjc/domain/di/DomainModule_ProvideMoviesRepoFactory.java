// Generated by Dagger (https://dagger.dev).
package com.vyom.movieappjc.domain.di;

import com.vyom.movieappjc.data.network.ApiService;
import com.vyom.movieappjc.domain.repository.MoviesRepo;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DomainModule_ProvideMoviesRepoFactory implements Factory<MoviesRepo> {
  private final Provider<ApiService> apiServiceProvider;

  public DomainModule_ProvideMoviesRepoFactory(Provider<ApiService> apiServiceProvider) {
    this.apiServiceProvider = apiServiceProvider;
  }

  @Override
  public MoviesRepo get() {
    return provideMoviesRepo(apiServiceProvider.get());
  }

  public static DomainModule_ProvideMoviesRepoFactory create(
      Provider<ApiService> apiServiceProvider) {
    return new DomainModule_ProvideMoviesRepoFactory(apiServiceProvider);
  }

  public static MoviesRepo provideMoviesRepo(ApiService apiService) {
    return Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideMoviesRepo(apiService));
  }
}
