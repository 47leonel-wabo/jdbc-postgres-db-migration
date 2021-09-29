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

    @DeleteMapping(path = {"/{id}"})
    public void deleteMoviById(final @PathVariable("id") Integer id) {
        mMovieService.removeMovie(id);
    }

    @PutMapping(path = {"/{id}"})
    public Movie updateMovieDetails(final @PathVariable("id") Integer id, final @RequestBody Movie movie) {
        return mMovieService.updateMovieData(id, movie);
    }

}
