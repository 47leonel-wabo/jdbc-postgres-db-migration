package com.work.beat.talent.jdbcpostgresdbmigration.movie;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = {"/api/v1/movies"})
public class MovieController {

    private final MovieService mMovieService;

    public MovieController(MovieService movieService) {
        mMovieService = movieService;
    }

    @GetMapping
    public Iterable<Movie> getAllMovies() {
        return mMovieService.getMovies();
    }

    @GetMapping(path = {"/{movieId}"})
    public Movie getMovieById(final @PathVariable("movieId") Integer movieId) {
        return mMovieService.getMovieById(movieId);
    }

    @PostMapping
    public Integer addNewMovie(@RequestBody final Movie movie) {
        return mMovieService.addMovie(movie);
    }

    // TODO 4: Delete movie by id (void returned)
    // TODO 5: Of course update movie

}
