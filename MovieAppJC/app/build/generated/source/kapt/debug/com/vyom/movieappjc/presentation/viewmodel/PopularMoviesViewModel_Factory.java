// Generated by Dagger (https://dagger.dev).
package com.vyom.movieappjc.presentation.viewmodel;

import com.vyom.movieappjc.domain.use_case.GetPopularMoviesUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class PopularMoviesViewModel_Factory implements Factory<PopularMoviesViewModel> {
  private final Provider<GetPopularMoviesUseCase> getPopularMoviesUseCaseProvider;

  public PopularMoviesViewModel_Factory(
      Provider<GetPopularMoviesUseCase> getPopularMoviesUseCaseProvider) {
    this.getPopularMoviesUseCaseProvider = getPopularMoviesUseCaseProvider;
  }

  @Override
  public PopularMoviesViewModel get() {
    return newInstance(getPopularMoviesUseCaseProvider.get());
  }

  public static PopularMoviesViewModel_Factory create(
      Provider<GetPopularMoviesUseCase> getPopularMoviesUseCaseProvider) {
    return new PopularMoviesViewModel_Factory(getPopularMoviesUseCaseProvider);
  }

  public static PopularMoviesViewModel newInstance(
      GetPopularMoviesUseCase getPopularMoviesUseCase) {
    return new PopularMoviesViewModel(getPopularMoviesUseCase);
  }
}