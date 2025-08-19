package org.example.cinema.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cinema.entity.Director;
import org.example.cinema.entity.Movie;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MovieResponseDto {
    private int id;
    private String name;
    private LocalDate releasedDate;
    private String description;
    private int runtime;
    private String genre;
    private Director director;
}