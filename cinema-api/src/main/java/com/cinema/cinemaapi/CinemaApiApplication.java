package com.cinema.cinemaapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication(scanBasePackages = {"com.cinema"})
@EnableOpenApi
public class CinemaApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaApiApplication.class, args);
    }

}
