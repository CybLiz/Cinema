package org.example.cinema.controller;

import org.example.cinema.dto.MovieReceiveDto;
import org.example.cinema.dto.MovieResponseDto;
import org.example.cinema.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/catalog/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("movies")
    public ResponseEntity<List<MovieResponseDto>> getAll() {
        return ResponseEntity.ok(movieService.get());
    }

    @GetMapping("movie/{id}")
    public ResponseEntity<MovieResponseDto> getOne(@PathVariable int id) {
        return ResponseEntity.ok(movieService.get(id));
    }

    @PostMapping
    public ResponseEntity<MovieResponseDto> create(@RequestBody MovieReceiveDto movieReceiveDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.create(movieReceiveDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponseDto> update(@PathVariable int id, @RequestBody MovieReceiveDto movieReceiveDto) {
        return ResponseEntity.ok(movieService.update(id, movieReceiveDto));
    }

    @GetMapping("/movies/{directorId}")
    public ResponseEntity<List<MovieResponseDto>> getAll(@PathVariable int directorId) {
        return ResponseEntity.ok(movieService.getMoviesByDirector(directorId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        movieService.delete(id);
        return ResponseEntity.ok(String.format("Movie with id %d is deleted", id));
    }





}
