package com.myresume.api.vacancy.controller;

import com.myresume.api.vacancy.MyResumeApiVacancyApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = MyResumeApiVacancyApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles(profiles = "test")
public class VacancyControllerITTest {
    private static final String URL = "/api/vacancy";
    private MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        this.mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Sql(scripts = {"classpath:/db/vacancy_insert.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = {"classpath:/db/vacancy_delete.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    @Test
    public void shouldReturnVacancyByUserAndPage() throws Exception {
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
                .andExpect(jsonPath("$[1].updatedOn", is("2023-12-15T10:00:09")));
    }
}
