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
    private String description;
    private Long active;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
