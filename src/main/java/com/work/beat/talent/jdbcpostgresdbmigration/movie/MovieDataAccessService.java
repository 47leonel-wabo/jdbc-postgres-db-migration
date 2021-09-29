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

    /*
     * For any operation which alter data in database, use "update()" method from jdbcTemplate
     * And for reading data use "query()" method from jdbcTemplate
     */

    @Override
    public Integer insertMovie(Movie movie) {
        String sqlQuery = """
                INSERT INTO movie(name, release_date)
                VALUES (?, ?);
                """;
        return mJdbcTemplate.update(sqlQuery, movie.name(), movie.releaseDate());
    }

    @Override
    public Iterable<Movie> fetchMovies() {
        String sqlQuery = """
                SELECT id, name, release_date
                FROM movie LIMIT 100;
                """;
        return mJdbcTemplate.query(sqlQuery, new MovieRowMapper());
    }

    @Override
    public Optional<Movie> fetchMovieById(Integer moveId) {
        String sqlQuery = """
                SELECT id, name, release_date
                FROM movie WHERE id = ?;
                """;
        List<Movie> movieList = mJdbcTemplate.query(sqlQuery, new MovieRowMapper(), moveId);
        return movieList.stream().findFirst();
    }

    @Override
    public Movie updateMovie(Integer movieId, Movie movieData) {
        String sqlQuery = """
                UPDATE movie
                SET name = ?, actors = ?, release_date = ?
                WHERE id = ?;
                """;
        // 'i' represents the number of updated rows
        int i = mJdbcTemplate.update(
                sqlQuery,
                movieData.name(),
                movieData.actors(),
                movieData.releaseDate(),
                movieId
        );
        if (i == 1) {
            return movieData;
        } else {
            return null;
        }
    }

    @Override
    public Integer deleteMovie(Integer movieId) {
        String sqlQuery = """
                DELETE FROM movie WHERE id = ?;
                """;
        return mJdbcTemplate.update(sqlQuery, movieId);
    }
}
