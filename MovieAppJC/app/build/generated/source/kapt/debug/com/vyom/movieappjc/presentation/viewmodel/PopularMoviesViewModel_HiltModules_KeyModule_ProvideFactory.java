// Generated by Dagger (https://dagger.dev).
package com.vyom.movieappjc.presentation.viewmodel;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class PopularMoviesViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
  @Override
  public String get() {
    return provide();
  }

  public static PopularMoviesViewModel_HiltModules_KeyModule_ProvideFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static String provide() {
    return Preconditions.checkNotNullFromProvides(PopularMoviesViewModel_HiltModules.KeyModule.provide());
  }

  private static final class InstanceHolder {
    private static final PopularMoviesViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new PopularMoviesViewModel_HiltModules_KeyModule_ProvideFactory();
  }
}
