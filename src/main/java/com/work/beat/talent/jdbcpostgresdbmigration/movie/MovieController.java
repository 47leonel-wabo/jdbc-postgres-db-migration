package com.work.beat.talent.jdbcpostgresdbmigration.movie;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = {"/api/v1/movies"})
public class MovieController {

    private final MovieDao mMovieDao;

    public MovieController(MovieDao movieDao) {
        mMovieDao = movieDao;
    }

    @GetMapping
    public Iterable<Movie> getAllMovies() {
        return mMovieDao.fetchMovies();
    }
    // TODO 2: Get movie by id

    @PostMapping
    public Integer addNewMovie(@RequestBody final Movie movie) {
        return mMovieDao.insertMovie(movie);
    }

    // TODO 4: Delete movie by id (void returned)
    // TODO 5: Of course update movie

}
