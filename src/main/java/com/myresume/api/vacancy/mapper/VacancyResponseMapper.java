package com.myresume.api.vacancy.mapper;


import com.myresume.api.vacancy.dto.VacancyResponseDto;
import com.myresume.api.vacancy.entity.Vacancy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VacancyResponseMapper extends SuperMapper<Vacancy, VacancyResponseDto> {
    Vacancy toEntity(VacancyResponseDto dto);

    VacancyResponseDto toDto(Vacancy vacancy);
}