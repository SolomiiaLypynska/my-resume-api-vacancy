package com.myresume.api.vacancy.dto;

import com.myresume.api.vacancy.enum_.*;
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
    private PositionLevel positionLevel;
    private Double workExperience;
    private CompanyType companyType;
    private EnglishLevel englishLevel;
    private Location location;
    private Long active;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
