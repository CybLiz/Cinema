package org.example.cinema.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cinema.entity.Movie;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DirectorResponseDto {
    private int id;
    private String name;
    private String lastName;
    private LocalDate dateofBirth;
    private String  description;
    private String  nationality;
    private Movie movie;




}
