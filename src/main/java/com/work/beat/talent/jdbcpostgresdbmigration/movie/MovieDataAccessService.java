package com.work.beat.talent.jdbcpostgresdbmigration.movie;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MovieDataAccessService implements MovieDao {
    @Override
    public Integer insertMovie(Movie movie) {
        return null;
    }

    @Override
    public Iterable<Movie> fetchMovies() {
        return null;
    }

    @Override
    public Optional<Movie> fetchMovieById(Integer moveId) {
        return Optional.empty();
    }

    @Override
    public Movie updateMovie(Integer movieId, Movie movieData) {
        return null;
    }

    @Override
    public Integer deleteMovie(Integer movieId) {
        throw new UnsupportedOperationException("Bla bla!");
    }
}
