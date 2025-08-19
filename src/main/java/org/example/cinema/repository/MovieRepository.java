package org.example.cinema.repository;

import org.example.cinema.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findMoviesByDirectorId(int directorId);


}
