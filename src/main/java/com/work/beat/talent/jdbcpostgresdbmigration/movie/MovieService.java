package com.work.beat.talent.jdbcpostgresdbmigration.movie;

import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final MovieDao mMovieDao;

    public MovieService(MovieDao movieDao) {
        mMovieDao = movieDao;
    }
}
