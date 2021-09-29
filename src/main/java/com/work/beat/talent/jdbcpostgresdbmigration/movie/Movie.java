package com.work.beat.talent.jdbcpostgresdbmigration.movie;

import com.work.beat.talent.jdbcpostgresdbmigration.actor.Actor;

import java.time.LocalDate;
import java.util.List;

public record Movie(
        Integer id,
        String name,
        List<Actor> actors,
        LocalDate releaseDate) {
}
