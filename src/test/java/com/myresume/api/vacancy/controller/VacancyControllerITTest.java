package com.myresume.api.vacancy.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.myresume.api.vacancy.MyResumeApiVacancyApplication;
import com.myresume.api.vacancy.dto.VacancyRequestDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringJUnitConfig
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = MyResumeApiVacancyApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles(profiles = "test")
class VacancyControllerITTest {
    private static final String URL = "/api/vacancy";
    private static final String VACANCY_REQUEST_PATH = "src/test/resources/json/vacancyRequest.json";
    private MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeAll
    public void setup() {
        this.mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @Sql(scripts = {"classpath:/db/vacancy_insert.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = {"classpath:/db/vacancy_delete.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void shouldReturnVacancyByUserAndPage() throws Exception {
        mvc.perform(get(URL + "/user/{userId}/page/{page}", 3, 0)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[1].vacancyId", is(4)))
                .andExpect(jsonPath("$[1].employerId", is(3)))
                .andExpect(jsonPath("$[1].companyName", is("Apple")))
                .andExpect(jsonPath("$[1].positionTitle", is("React Developer")))
                .andExpect(jsonPath("$[1].requirements", is("React.js, JS")))
                .andExpect(jsonPath("$[1].description", is(nullValue())))
                .andExpect(jsonPath("$[1].active", is(1)))
                .andExpect(jsonPath("$[1].createdOn", is("2023-12-09T10:00:09")))
                .andExpect(jsonPath("$[1].updatedOn", is("2023-12-15T10:00:09")))
                .andExpect(jsonPath("$[1].employmentType", is("PART_TIME")))
                .andExpect(jsonPath("$[1].salary", is(4000)))
                .andExpect(jsonPath("$[1].positionLevel", is("senior")))
                .andExpect(jsonPath("$[1].workExperience", is(1.5)))
                .andExpect(jsonPath("$[1].companyType", is("OUTSTAFF")))
                .andExpect(jsonPath("$[1].englishLevel", is("beginnerOrElementary")))
                .andExpect(jsonPath("$[1].location", is("office")))
                .andExpect(jsonPath("$[1].toolAndTechnology", is("React.js, antd, JavaScript, HTML, CSS")));
    }

    @Test
    @Sql(scripts = {"classpath:/db/vacancy_delete.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void shouldCreateAndReturnVacancy() throws Exception {
        mvc.perform(post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(extractJson(0)))
                .andExpect(status().isCreated())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("vacancyId", is(1)))
                .andExpect(jsonPath("employerId", is(3)))
                .andExpect(jsonPath("companyName", is("Apple")))
                .andExpect(jsonPath("positionTitle", is("Java Developer")))
                .andExpect(jsonPath("requirements", is("Java, SQL, Spring Boot")))
                .andExpect(jsonPath("description", is("Apple company")))
                .andExpect(jsonPath("employmentType", is("FULL_TIME")))
                .andExpect(jsonPath("salary", is(300)))
                .andExpect(jsonPath("positionLevel", is("trainee")))
                .andExpect(jsonPath("workExperience", is(1.5)))
                .andExpect(jsonPath("companyType", is("OUTSOURCE")))
                .andExpect(jsonPath("englishLevel", is("preIntermediate")))
                .andExpect(jsonPath("location", is("remote")))
                .andExpect(jsonPath("toolAndTechnology", is("Java, SQL, Spring")));
    }

    @Test
    @Sql(scripts = {"classpath:/db/vacancy_insert.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = {"classpath:/db/vacancy_delete.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void shouldUpdateAndReturnVacancy() throws Exception {
        mvc.perform(put(URL + "/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(extractJson(1)))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("employerId", is(3)))
                .andExpect(jsonPath("companyName", is("Apple")))
                .andExpect(jsonPath("positionTitle", is("Senior Java Developer")))
                .andExpect(jsonPath("requirements", is("Java, SQL, Spring Boot, Hibernate")))
                .andExpect(jsonPath("description", is("Apple company")))
                .andExpect(jsonPath("employmentType", is("FREELANCE")))
                .andExpect(jsonPath("salary", is(2000)))
                .andExpect(jsonPath("positionLevel", is("middle")))
                .andExpect(jsonPath("workExperience", is(1.5)))
                .andExpect(jsonPath("companyType", is("OUTSTAFF")))
                .andExpect(jsonPath("englishLevel", is("upperIntermediate")))
                .andExpect(jsonPath("location", is("office")))
                .andExpect(jsonPath("toolAndTechnology", is("Java, SQL, Spring, Hibernate, AWS")));
        ;
    }

    @Test
    @Sql(scripts = {"classpath:/db/vacancy_insert.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = {"classpath:/db/vacancy_delete.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void shouldDeactivateAndReturnVacancy() throws Exception {
        mvc.perform(put(URL + "/deactivate/{id}", 6)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("employerId", is(2)))
                .andExpect(jsonPath("companyName", is("Google")))
                .andExpect(jsonPath("positionTitle", is("Devops")))
                .andExpect(jsonPath("requirements", is("Docker")))
                .andExpect(jsonPath("description", is(nullValue())))
                .andExpect(jsonPath("active", is(0)))
                .andExpect(jsonPath("createdOn", is("2023-12-18T10:00:09")))
                .andExpect(jsonPath("updatedOn", is("2023-12-15T10:00:09")))
                .andExpect(jsonPath("employmentType", is("SELF_EMPLOYED")))
                .andExpect(jsonPath("salary", is(7000)))
                .andExpect(jsonPath("positionLevel", is("lead")))
                .andExpect(jsonPath("workExperience", is(2.0)))
                .andExpect(jsonPath("companyType", is("OUTSOURCE")))
                .andExpect(jsonPath("englishLevel", is("upperIntermediate")))
                .andExpect(jsonPath("location", is("office")))
                .andExpect(jsonPath("toolAndTechnology", is("Docker, AWS, EC2, S3")));
        ;
    }

    private String extractJson(int index) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        List<VacancyRequestDto> requestDtoList = objectMapper
                .readValue(Files.readString(Path.of(VACANCY_REQUEST_PATH)), new TypeReference<>() {
                });
        return objectMapper.writeValueAsString(requestDtoList.get(index));
    }
}
