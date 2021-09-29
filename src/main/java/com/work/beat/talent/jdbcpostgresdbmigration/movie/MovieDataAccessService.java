package com.work.beat.talent.jdbcpostgresdbmigration.movie;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MovieDataAccessService implements MovieDao {

    private final JdbcTemplate mJdbcTemplate;

    public MovieDataAccessService(JdbcTemplate jdbcTemplate) {
        mJdbcTemplate = jdbcTemplate;
    }

    @Override
    public Integer insertMovie(Movie movie) {
        String sqlQuery = """
                INSERT INTO movie(name, release_date) VALUES (?, ?);
                """;
        return mJdbcTemplate.update(sqlQuery, movie.name(), movie.releaseDate());
    }

    @Override
    public Iterable<Movie> fetchMovies() {
        String sqlQuery = """
                SELECT id, name, release_date FROM movie LIMIT 100;
                """;
        return mJdbcTemplate.query(sqlQuery, new MovieRowMapper());
    }

    @Override
    public Optional<Movie> fetchMovieById(Integer moveId) {
        String sqlQuery = """
                SELECT id, name, release_date FROM movie WHERE id = ?;
                """;
        List<Movie> movieList = mJdbcTemplate.query(sqlQuery, new MovieRowMapper(), moveId);
        return movieList.stream().findFirst();
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
