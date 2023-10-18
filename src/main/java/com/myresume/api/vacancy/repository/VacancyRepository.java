package com.myresume.api.vacancy.repository;

import com.myresume.api.vacancy.entity.Vacancy;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
    List<Vacancy> findAllByEmployerIdAndActive(Pageable pageable, Long employerId, Long active);
}