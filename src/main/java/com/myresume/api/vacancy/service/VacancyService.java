package com.myresume.api.vacancy.service;


import com.myresume.api.vacancy.dto.VacancyRequestDto;
import com.myresume.api.vacancy.dto.VacancyResponseDto;

import java.util.List;

public interface VacancyService {
    VacancyResponseDto create(VacancyRequestDto dto);

    List<VacancyResponseDto> getVacancies(Long employerId, int page);

    VacancyRequestDto update(Long id, VacancyRequestDto dto);

    VacancyResponseDto deactivate(Long id);

    List<VacancyResponseDto> findAll();
}
