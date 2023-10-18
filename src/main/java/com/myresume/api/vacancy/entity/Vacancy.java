package com.myresume.api.vacancy.entity;

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
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "ACTIVE", nullable = false, columnDefinition = "NUMBER DEFAULT 1")
    private Long active;
    @Column(name = "CREATED_ON", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdOn;
    @Column(name = "UPDATED_ON")
    private LocalDateTime updatedOn;
}
