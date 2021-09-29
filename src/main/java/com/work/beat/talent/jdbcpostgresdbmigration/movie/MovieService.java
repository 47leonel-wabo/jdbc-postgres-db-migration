package com.work.beat.talent.jdbcpostgresdbmigration.movie;

import com.work.beat.talent.jdbcpostgresdbmigration.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public void removeMovie(final Integer movieId) {
        Optional<Movie> optionalMovie = mMovieDao.fetchMovieById(movieId);
        optionalMovie.ifPresentOrElse(movie -> {
            // if data is present, perform deletion
            Integer deleteMovie = mMovieDao.deleteMovie(movieId); // good deletion affect one row only
            if (deleteMovie != 1) {
                throw new IllegalArgumentException(String.format("Could not delete movie with ID %s", movieId));
            }
        }, () -> {
            // if there is no data present
            throw new NotFoundException(String.format("Movie with ID %s not found!", movieId));
        });
    }

    public Movie updateMovieData(final Integer id, final Movie movie) {
        Movie updateMovie = mMovieDao.updateMovie(id, movie);
        if (updateMovie == null) {
            throw new NotFoundException(String.format("Unable to fetch movie with ID %s", id));
        }
        return updateMovie;
    }
}
