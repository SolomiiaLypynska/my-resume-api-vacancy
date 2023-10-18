package com.myresume.api.vacancy.mapper;

import com.myresume.api.vacancy.dto.VacancyRequestDto;
import com.myresume.api.vacancy.entity.Vacancy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VacancyRequestMapper extends SuperMapper<Vacancy, VacancyRequestDto> {
    Vacancy toEntity(VacancyRequestDto dto);

    VacancyRequestDto toDto(Vacancy vacancy);
}
