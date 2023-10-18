package com.myresume.api.vacancy.service;


import com.myresume.api.vacancy.dto.VacancyRequestDto;
import com.myresume.api.vacancy.dto.VacancyResponseDto;

import java.util.List;

public interface VacancyService {
    void create(VacancyRequestDto dto);

    List<VacancyResponseDto> getWorkExperience(Long employerId, int page);

    VacancyRequestDto update(Long id, VacancyRequestDto dto);

    void deactivate(Long id);
}
