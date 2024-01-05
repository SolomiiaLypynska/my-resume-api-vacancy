package com.myresume.api.vacancy.dto;

import com.myresume.api.vacancy.enum_.EmploymentType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VacancyFilterSearchDto {
    private String position;
    private Long salary;
    private EmploymentType employmentType;
    private String companyType;
    private String englishLevel;
    private String positionLevel;
}
