package com.myresume.api.vacancy.service.implementation;


import com.myresume.api.vacancy.dto.VacancyRequestDto;
import com.myresume.api.vacancy.dto.VacancyResponseDto;
import com.myresume.api.vacancy.entity.Vacancy;
import com.myresume.api.vacancy.exception.exception_type.NotFoundException;
import com.myresume.api.vacancy.mapper.VacancyRequestMapper;
import com.myresume.api.vacancy.mapper.VacancyResponseMapper;
import com.myresume.api.vacancy.repository.VacancyRepository;
import com.myresume.api.vacancy.service.VacancyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class VacancyServiceImpl implements VacancyService {
    @Autowired
    private VacancyRepository vacancyRepository;
    @Autowired
    private VacancyRequestMapper vacancyRequestMapper;
    @Autowired
    private VacancyResponseMapper vacancyResponseMapper;

    @Override
    public VacancyResponseDto create(VacancyRequestDto dto) {
        log.info("Started create new Vacancy: {};", dto);
        Vacancy vacancy = vacancyRequestMapper.toEntity(dto);
        vacancy.setEmployerId(dto.getEmployerId());
        vacancyRepository.save(vacancy);
        log.info("Successfully created new Vacancy;");
        return vacancyResponseMapper.toDto(vacancy);
    }

    @Override
    public List<VacancyResponseDto> getWorkExperience(Long employerId, int page) {
        log.info("Starting get vacancies by employerId {} and page {}.", employerId, page);
        Pageable pageable = PageRequest.of(page, 5);
        List<Vacancy> vacancyList = vacancyRepository.findAllByEmployerIdAndActive(pageable, employerId, 1L);
        log.info("Successfully getting vacancies");
        return vacancyResponseMapper.toDto(vacancyList);
    }

    @Override
    public VacancyRequestDto update(Long id, VacancyRequestDto dto) {
        log.info("Started updating Vacancy by id: {};", id);
        Vacancy vacancy = vacancyRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found Vacancy by id: " + id));
        vacancy.setCompanyName(dto.getCompanyName());
        vacancy.setPositionTitle(dto.getPositionTitle());
        vacancy.setRequirements(dto.getRequirements());
        vacancy.setDescription(dto.getDescription());
        vacancy.setEmploymentType(dto.getEmploymentType());
        vacancy.setSalary(dto.getSalary());
        vacancy.setPositionLevel(dto.getPositionLevel());

        vacancyRepository.save(vacancy);
        log.info("Successfully update Vacancy;");
        return vacancyRequestMapper.toDto(vacancy);
    }

    @Override
    public VacancyResponseDto deactivate(Long id) {
        log.info("Started deactivate Vacancy by id: {};", id);
        Vacancy vacancy = vacancyRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found Vacancy by id: " + id));
        vacancy.setActive(0L);
        vacancyRepository.save(vacancy);
        log.info("Successfully deactivate Vacancy;");
        return vacancyResponseMapper.toDto(vacancy);
    }

    @Override
    public List<VacancyResponseDto> findAll() {
        log.info("Starting get all vacancies.");
        return vacancyResponseMapper.toDto(vacancyRepository.findAll());
    }
}
