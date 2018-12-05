package com.test;

import com.model.Pelicula;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.model"})
@EnableJpaRepositories(basePackages = {"com.repository"})
@ComponentScan(basePackages = {"com.controller"})
@SpringBootApplication
@EnableJpaAuditing

public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
