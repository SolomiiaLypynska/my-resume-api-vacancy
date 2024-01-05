package com.myresume.api.vacancy.dto;

import com.myresume.api.vacancy.enum_.CompanyType;
import com.myresume.api.vacancy.enum_.EmploymentType;
import com.myresume.api.vacancy.enum_.EnglishLevel;
import com.myresume.api.vacancy.enum_.PositionLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VacancyFilterSearchDto {
    private String position;
    private Long salary;
    private EmploymentType employmentType;
    private CompanyType companyType;
    private EnglishLevel englishLevel;
    private PositionLevel positionLevel;
}
