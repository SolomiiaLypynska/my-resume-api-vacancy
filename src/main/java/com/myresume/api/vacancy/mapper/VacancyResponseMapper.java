package com.myresume.api.vacancy.mapper;


import com.myresume.api.vacancy.dto.VacancyResponseDto;
import com.myresume.api.vacancy.entity.Vacancy;
import com.myresume.api.vacancy.enum_.EnglishLevel;
import org.mapstruct.Mapper;

import java.util.Objects;

@Mapper(componentModel = "spring")
public interface VacancyResponseMapper extends SuperMapper<Vacancy, VacancyResponseDto> {
    Vacancy toEntity(VacancyResponseDto dto);

    VacancyResponseDto toDto(Vacancy vacancy);

    default String map(EnglishLevel englishLevel) {
        return Objects.nonNull(englishLevel) ? englishLevel.value : "";
    }
}