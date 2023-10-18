package com.myresume.api.vacancy.controller;

import com.myresume.api.vacancy.dto.VacancyRequestDto;
import com.myresume.api.vacancy.dto.VacancyResponseDto;
import com.myresume.api.vacancy.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/vacancy")
public class VacancyController {
    @Autowired
    private VacancyService vacancyService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> create(@Valid @RequestBody VacancyRequestDto dto) {
        vacancyService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(path = "/user/{userId}/page/{page}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<VacancyResponseDto>> getAllByUserAndPage(@PathVariable Long userId, @PathVariable int page) {
        return ResponseEntity.status(HttpStatus.OK).body(vacancyService.getWorkExperience(userId, page));
    }

    @PutMapping(path = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<VacancyRequestDto> update(@PathVariable Long id, @Valid @RequestBody VacancyRequestDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacancyService.update(id, dto));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Void> deactivate(@PathVariable Long id) {
        vacancyService.deactivate(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
