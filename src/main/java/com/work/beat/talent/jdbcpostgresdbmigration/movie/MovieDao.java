package com.work.beat.talent.jdbcpostgresdbmigration.movie;

import java.util.Optional;

public interface MovieDao {
    Integer insertMovie(final Movie movie);
    Iterable<Movie> fetchMovies();
    Optional<Movie> fetchMovieById(final Integer moveId);
    Movie updateMovie(final Integer movieId, final Movie movieData);
    Integer deleteMovie(final Integer movieId);
}
