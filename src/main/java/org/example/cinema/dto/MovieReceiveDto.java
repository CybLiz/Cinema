package org.example.cinema.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cinema.entity.Director;
import org.example.cinema.entity.Movie;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MovieReceiveDto {

    @JsonIgnore
    private int id;
    private String name;
    private LocalDate releasedDate;
    private String  description;
    private int runtime;
    private String  genre;
    private Director director;

    public Movie dtoToEntity() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return Movie.builder()

                .name(name)
                .releasedDate(releasedDate)
                .description(description)
                .runtime(runtime)
                .genre(genre)
                .director(director)
                .build();
    }
}
