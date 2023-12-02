import 'dart:io';

import 'package:dartz/dartz.dart';

import '../../domain/entities/app_error.dart';
import '../../domain/entities/movie_entity.dart';
import '../../domain/repositories/movie_repository.dart';
import '../data_sources/movie_local_data_source.dart';
import '../data_sources/movie_remote_data_source.dart';
import '../models/castcrew_data_model.dart';
import '../models/movie_detail_model.dart';
import '../models/movie_model.dart';
import '../models/video_model.dart';
import '../tables/movie_table.dart';

class MovieRepositoryImpl extends MovieRepository {
  final MovieRemoteDataResource remoteDataResource;
  final MovieLocalDataSource localDataSource;

  final Map<String, dynamic> _cache = {};
  final Duration cacheExpiration = const Duration(minutes: 30);

  MovieRepositoryImpl(
      this.remoteDataResource,
      this.localDataSource,
      );

  Future<Either<AppError, T>> _withCache<T>(
      String key,
      Future<T> Function() fetchData,
      ) async {
    try {
      if (_cache.containsKey(key)) {
        final cachedData = _cache[key] as T;
        return Right(cachedData);
      }

      final freshData = await fetchData();
      _cache[key] = freshData;

      Future.delayed(cacheExpiration, () {
        _cache.remove(key);
      });

      return Right(freshData);
    } on SocketException {
      return const Left(AppError(AppErrorType.network));
    } on Exception {
      return const Left(AppError(AppErrorType.api));
    }
  }

  @override
  Future<Either<AppError, List<MovieModel>>> getTrending() async =>
      _withCache('getTrending', () => remoteDataResource.getTrending());

  @override
  Future<Either<AppError, List<MovieEntity>>> getCommingsoon() async =>
      _withCache('getCommingSoon', () => remoteDataResource.getCommingSoon());

  @override
  Future<Either<AppError, List<MovieEntity>>> getPlayingNow() async =>
      _withCache('getPlayingNow', () => remoteDataResource.getPlayingNow());

  @override
  Future<Either<AppError, List<MovieEntity>>> getPopular() async =>
      _withCache('getPopular', () => remoteDataResource.getPopular());

  @override
  Future<Either<AppError, MovieDetailModel>> getMovieDetail(int id) async =>
      _withCache('getMovieDetail$id', () => remoteDataResource.getMovieDetail(id));

  @override
  Future<Either<AppError, List<CastModel>>> getCastCrew(int id) async =>
      _withCache('getCastCrew$id', () => remoteDataResource.getCastCrew(id));

  @override
  Future<Either<AppError, List<VideoModel>>> getVideos(int id) async =>
      _withCache('getVideos$id', () => remoteDataResource.getVideos(id));

  @override
  Future<Either<AppError, List<MovieModel>>> getSearchedMovies(String searchTerm) async =>
      _withCache('getSearchedMovies$searchTerm', () => remoteDataResource.getSearchedMovies(searchTerm));

  @override
  Future<Either<AppError, bool>> checkIfMovieisFavorite(int movieId) async {
    try {
      final response = await localDataSource.checkIfMovieisFavorite(movieId);
      return Right(response);
    } on Exception {
      return const Left(AppError(AppErrorType.database));
    }
  }

  @override
  Future<Either<AppError, void>> deleteFavoriteMovie(int movieId) async {
    try {
      final response = await localDataSource.deleteFavoriteMovie(movieId);
      return Right(response);
    } on Exception {
      return const Left(AppError(AppErrorType.database));
    }
  }

  @override
  Future<Either<AppError, List<MovieEntity>>> getFavoriteMovies() async {
    try {
      final response = await localDataSource.getFavoriteMovies();
      return Right(response);
    } on Exception {
      return const Left(AppError(AppErrorType.database));
    }
  }

  @override
  Future<Either<AppError, void>> saveMovie(MovieEntity movieEntity) async {
    try {
      final response = await localDataSource.saveMovie(
        MovieTable.fromMovieEntity(movieEntity),
      );
      return Right(response);
    } on Exception {
      return const Left(AppError(AppErrorType.database));
    }
  }
}
