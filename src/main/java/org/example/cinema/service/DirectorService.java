package org.example.cinema.service;

import org.example.cinema.dto.DirectorReceiveDto;
import org.example.cinema.dto.DirectorResponseDto;
import org.example.cinema.entity.Director;
import org.example.cinema.exception.NotFoundException;
import org.example.cinema.repository.DirectorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {

    private final DirectorRepository directorRepository;

    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public DirectorResponseDto create(DirectorReceiveDto directorReceiveDto) {
        return directorRepository.save(directorReceiveDto.dtoToEntity()).entityToDto();
    }

    public DirectorResponseDto get(int id) {
        return directorRepository.findById(id).orElseThrow(NotFoundException::new).entityToDto();
    }

    public List<DirectorResponseDto> get() {
        return directorRepository.findAll().stream().map(Director::entityToDto).toList();
    }

    public DirectorResponseDto update(int id, DirectorReceiveDto directorReceiveDto) {
        Director director = directorRepository.findById(id).orElseThrow(NotFoundException::new);
        Director getDirector = directorReceiveDto.dtoToEntity();
        director.setName(getDirector.getName());
        director.setLastName(getDirector.getLastName());
        director.setDateofBirth(getDirector.getDateofBirth());
        director.setNationality(getDirector.getNationality());

        return directorRepository.save(director).entityToDto();
    }

    public void delete(int id) {
        directorRepository.deleteById(id);
    }
}



