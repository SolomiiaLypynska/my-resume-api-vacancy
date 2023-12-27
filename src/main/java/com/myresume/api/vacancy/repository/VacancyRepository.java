package com.myresume.api.vacancy.repository;

import com.myresume.api.vacancy.entity.Vacancy;
import com.myresume.api.vacancy.enum_.CompanyType;
import com.myresume.api.vacancy.enum_.EmploymentType;
import com.myresume.api.vacancy.enum_.EnglishLevel;
import com.myresume.api.vacancy.enum_.PositionLevel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
    List<Vacancy> findAllByEmployerIdAndActive(Pageable pageable, Long employerId, Long active);

    @Query("select v from Vacancy v where (:positionTitle is null or v.positionTitle = :positionTitle) " +
            "and (:salary is null or v.salary = :salary) " +
            "and (:companyType is null or v.companyType = :companyType) " +
            "and (:employmentType is null or v.employmentType = :employmentType) " +
            "and (:englishLevel is null or v.englishLevel = :englishLevel) " +
            "and (:positionLevel is null or v.positionLevel = :positionLevel) ")
    List<Vacancy> findAllByFilters(@Param("positionTitle") String positionTitle,
                                   @Param("salary") Long salary,
                                   @Param("companyType") CompanyType companyType,
                                   @Param("employmentType") EmploymentType employmentType,
                                   @Param("englishLevel") EnglishLevel englishLevel,
                                   @Param("positionLevel") PositionLevel positionLevel);
}