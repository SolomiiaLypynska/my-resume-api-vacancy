package com.myresume.api.vacancy.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VacancyFilterSearchDto {
    private String position;
    private Long salary;
    private String employmentType;
    private String companyType;
    private String englishLevel;
    private String positionLevel;
}
