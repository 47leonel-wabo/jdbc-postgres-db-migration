package com.work.beat.talent.jdbcpostgresdbmigration.movie;

import com.work.beat.talent.jdbcpostgresdbmigration.exception.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final MovieDao mMovieDao;

    public MovieService(MovieDao movieDao) {
        mMovieDao = movieDao;
    }

    public Iterable<Movie> getMovies() {
        return mMovieDao.fetchMovies();
    }

    public Integer addMovie(final Movie movie) {
        return mMovieDao.insertMovie(movie);
    }

    public Movie getMovieById(final Integer id) {
        return mMovieDao.fetchMovieById(id).orElseThrow(() -> new NotFoundException(String.format("Unable to fetch movie with ID %s", id)));
    }
}
