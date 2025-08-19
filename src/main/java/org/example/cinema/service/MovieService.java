package org.example.cinema.service;

import org.example.cinema.dto.MovieReceiveDto;
import org.example.cinema.dto.MovieResponseDto;
import org.example.cinema.entity.Movie;
import org.example.cinema.exception.NotFoundException;
import org.example.cinema.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public MovieResponseDto create(MovieReceiveDto movieReceiveDto) {
        return movieRepository.save(movieReceiveDto.dtoToEntity()).entityToDto();
    }

    public MovieResponseDto get(int id) {
        return movieRepository.findById(id).orElseThrow(NotFoundException::new).entityToDto();
    }

    public List<MovieResponseDto> get() {
        return movieRepository.findAll().stream().map(Movie::entityToDto).toList();
    }

    public MovieResponseDto update(int id, MovieReceiveDto movieReceiveDto) {
        Movie movie = movieRepository.findById(id).orElseThrow(NotFoundException::new);
        Movie getMovie = movieReceiveDto.dtoToEntity();
        movie.setName(getMovie.getName());
        movie.setReleasedDate(getMovie.getReleasedDate());
        movie.setDescription(getMovie.getDescription());
        movie.setRuntime(getMovie.getRuntime());
        movie.setGenre(getMovie.getGenre());
        movie.setDirector(getMovie.getDirector());

        return movieRepository.save(movie).entityToDto();
    }

    public List<MovieResponseDto> getMoviesByDirector(int directorId) {
        return movieRepository.findMoviesByDirectorId(directorId)
                .stream()
                .map(Movie::entityToDto)
                .toList();
    }


    public void delete(int id) {
        movieRepository.deleteById(id);
    }
}
