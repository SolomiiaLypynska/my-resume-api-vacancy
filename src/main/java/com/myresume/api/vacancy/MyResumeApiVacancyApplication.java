package com.myresume.api.vacancy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MyResumeApiVacancyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyResumeApiVacancyApplication.class, args);
    }

}
