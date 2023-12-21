package com.myresume.api.vacancy.dto;

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
    private String employmentType;
    private Long salary;
    private String positionLevel;
    private Double workExperience;
    private String companyType;
    private String englishLevel;
    private String location;
    private Long active;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
