package org.example.cinema.controller;

import org.example.cinema.dto.DirectorReceiveDto;
import org.example.cinema.dto.DirectorResponseDto;
import org.example.cinema.service.DirectorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    @RequestMapping("api/catalog/director")
    public class DirectorController {

        private final DirectorService directorService;

        public DirectorController(DirectorService directorService) {
            this.directorService = directorService;
        }

        @GetMapping("directors")
        public ResponseEntity<List<DirectorResponseDto>> getAll() {
            return ResponseEntity.ok(directorService.get());
        }

        @GetMapping("director/{id}")
        public ResponseEntity<DirectorResponseDto> getOne(@PathVariable int id) {
            return ResponseEntity.ok(directorService.get(id));
        }

        @PostMapping
        public ResponseEntity<DirectorResponseDto> create(@RequestBody DirectorReceiveDto directorReceiveDto) {
            return ResponseEntity.status(HttpStatus.CREATED).body(directorService.create(directorReceiveDto));
        }

        @PutMapping("/{id}")
        public ResponseEntity<DirectorResponseDto> update(@PathVariable int id, @RequestBody DirectorReceiveDto directorReceiveDto) {
            return ResponseEntity.ok(directorService.update(id, directorReceiveDto));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<String> delete(@PathVariable int id) {
            directorService.delete(id);
            return ResponseEntity.ok(String.format("Director with id %d is deleted", id));
        }

    }
