package com.myresume.api.vacancy.dto;

import com.myresume.api.vacancy.enum_.EmploymentType;
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
    @NotNull(message = "ToolAndTechnology can not be null")
    @Size(min = 2, message = "ToolAndTechnology must be more than 2 characters")
    private String toolAndTechnology;
    @NotNull(message = "Description can not be null")
    @Size(min = 10, message = "Description must be more than 10 characters")
    private String description;
    @NotNull(message = "Employment Type can not be null")
    private EmploymentType employmentType;
    private Long salary;
    @NotNull(message = "Position Level can not be null")
    private String positionLevel;
    private Double workExperience;
    @NotNull(message = "Company Type can not be null")
    private String companyType;
    @NotNull(message = "English Level can not be null")
    private String englishLevel;
    @NotNull(message = "Location can not be null")
    @Size(min = 2, message = "Location must be more than 2 characters")
    private String location;
}
