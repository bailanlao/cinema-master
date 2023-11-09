package com.cinema.cinemaapi.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan({"com.cinema.cinemaapi.dao","com.cinema.cinemambp.mapper"})
public class MybatisConfig {
}
