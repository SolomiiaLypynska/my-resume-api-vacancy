package com.myresume.api.vacancy.dto;

import com.myresume.api.vacancy.enum_.CompanyType;
import com.myresume.api.vacancy.enum_.EmploymentType;
import com.myresume.api.vacancy.enum_.EnglishLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class VacancyResponseDto {
    private Long vacancyId;
    private Long employerId;
    private String companyName;
    private String positionTitle;
    private String requirements;
    private String toolAndTechnology;
    private String description;
    private EmploymentType employmentType;
    private Long salary;
    private String positionLevel;
    private Double workExperience;
    private CompanyType companyType;
    private EnglishLevel englishLevel;
    private String location;
    private Long active;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
