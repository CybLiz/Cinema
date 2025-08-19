package org.example.cinema.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cinema.dto.DirectorResponseDto;
import org.example.cinema.dto.MovieResponseDto;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Movie {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDate releasedDate;
    private String  description;
    private int runtime;
    private String  genre;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;


    public MovieResponseDto entityToDto() {
        return MovieResponseDto.builder()
                .id(id)
                .name(name)
                .releasedDate(releasedDate)
                .description(description)
                .runtime(runtime)
                .genre(genre)
                .director(director)
                .build();
    }


}
