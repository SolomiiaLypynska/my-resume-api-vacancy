package com.myresume.api.vacancy.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class VacancyRequestDto {
    private Long employerId;
    @NotNull(message = "CompanyName can not be null")
    @Size(min = 2, message = "CompanyName must be more than 2 characters")
    private String companyName;
    @NotNull(message = "PositionTitle can not be null")
    @Size(min = 2, message = "PositionTitle must be more than 2 characters")
    private String positionTitle;
    @NotNull(message = "Requirements can not be null")
    @Size(min = 10, message = "Requirements must be more than 10 characters")
    private String requirements;
    @NotNull(message = "Description can not be null")
    @Size(min = 10, message = "Description must be more than 10 characters")
    private String description;
    private String employmentType;
    private Long salary;
    private String positionLevel;
    private Double workExperience;
    private String companyType;
    @NotNull(message = "English Level can not be null")
    private String englishLevel;
}
