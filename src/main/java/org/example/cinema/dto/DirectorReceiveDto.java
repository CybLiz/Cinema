package org.example.cinema.dto;

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
public class DirectorReceiveDto {
    private int id;
    private String name;
    private String lastName;
    private LocalDate dateofBirth;
    private String  description;
    private String  nationality;
    private Movie movie;


    public Director dtoToEntity() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return Director.builder()

                .id(id)
                .name(name)
                .lastName(lastName)
                .dateofBirth(dateofBirth)
                .description(description)
                .nationality(nationality)
                .build();
    }
}
