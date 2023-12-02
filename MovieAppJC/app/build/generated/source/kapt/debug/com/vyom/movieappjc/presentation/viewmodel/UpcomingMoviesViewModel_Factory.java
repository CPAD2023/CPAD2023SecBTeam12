// Generated by Dagger (https://dagger.dev).
package com.vyom.movieappjc.presentation.viewmodel;

import com.vyom.movieappjc.domain.use_case.GetUpcomingMoviesUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class UpcomingMoviesViewModel_Factory implements Factory<UpcomingMoviesViewModel> {
  private final Provider<GetUpcomingMoviesUseCase> getUpcomingMoviesUseCaseProvider;

  public UpcomingMoviesViewModel_Factory(
      Provider<GetUpcomingMoviesUseCase> getUpcomingMoviesUseCaseProvider) {
    this.getUpcomingMoviesUseCaseProvider = getUpcomingMoviesUseCaseProvider;
  }

  @Override
  public UpcomingMoviesViewModel get() {
    return newInstance(getUpcomingMoviesUseCaseProvider.get());
  }

  public static UpcomingMoviesViewModel_Factory create(
      Provider<GetUpcomingMoviesUseCase> getUpcomingMoviesUseCaseProvider) {
    return new UpcomingMoviesViewModel_Factory(getUpcomingMoviesUseCaseProvider);
  }

  public static UpcomingMoviesViewModel newInstance(
      GetUpcomingMoviesUseCase getUpcomingMoviesUseCase) {
    return new UpcomingMoviesViewModel(getUpcomingMoviesUseCase);
  }
}
