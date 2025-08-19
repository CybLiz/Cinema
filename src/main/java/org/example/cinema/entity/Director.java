package org.example.cinema.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cinema.dto.DirectorResponseDto;


import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String lastName;
    private LocalDate dateofBirth;
    private String  description;
    private String  nationality;

    @OneToMany
    private List<Movie> movies;



    public DirectorResponseDto entityToDto() {
        return DirectorResponseDto.builder()
                .id(id)
                .name(name)
                .lastName(lastName)
                .dateofBirth(dateofBirth)
                .description(description)
                .nationality(nationality)
                .build();
    }


}
