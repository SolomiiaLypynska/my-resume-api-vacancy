package com.myresume.api.vacancy.entity;

import com.myresume.api.vacancy.enum_.CompanyType;
import com.myresume.api.vacancy.enum_.EmploymentType;
import com.myresume.api.vacancy.enum_.EnglishLevel;
import com.myresume.api.vacancy.enum_.PositionLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@DynamicInsert
@Entity
@Table(name = "VACANCY")
@SequenceGenerator(name = "SEQ_VACANCY", sequenceName = "SEQ_VACANCY", allocationSize = 1)
public class Vacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_VACANCY")
    @Column(name = "VACANCY_ID")
    private Long vacancyId;
    @Column(name = "EMPLOYER_ID")
    private Long employerId;
    @Column(name = "COMPANY_NAME")
    private String companyName;
    @Column(name = "POSITION_TITLE")
    private String positionTitle;
    @Column(name = "REQUIREMENTS")
    private String requirements;
    @Column(name = "DESCRIPTION", columnDefinition = "CLOB")
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "EMPLOYMENT_TYPE")
    private EmploymentType employmentType;
    @Column(name = "SALARY")
    private Long salary;
    @Enumerated(EnumType.STRING)
    @Column(name = "POSITION_LEVEL")
    private PositionLevel positionLevel;
    @Column(name = "WORK_EXPERIENCE")
    private Double workExperience;
    @Enumerated(EnumType.STRING)
    @Column(name = "COMPANY_TYPE")
    private CompanyType companyType;
    @Enumerated(EnumType.STRING)
    @Column(name = "ENGLISH_LEVEL")
    private EnglishLevel englishLevel;
    @Column(name = "ACTIVE", nullable = false, columnDefinition = "NUMBER DEFAULT 1")
    private Long active;
    @Column(name = "CREATED_ON", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdOn;
    @Column(name = "UPDATED_ON")
    private LocalDateTime updatedOn;
}
