package com.cinema.cinemaapi.config;/**
 * @Description
 * @Author
 * @Date 2023/10/20
 */

import com.cinema.cinemacommon.config.BaseSwaggerConfig;
import com.cinema.cinemacommon.domain.SwaggerProperties;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @FileName Swagger2Config
 * @Description
 * @Author ht
 * @date 2023-10-20
 **/
@Configuration
public class Swagger2Config extends BaseSwaggerConfig {
    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.cinema.cinemaapi.controller")
                .title("电影后台管理系统")
                .description("电影后台相关接口文档")
                .contactName("tj")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }

    @Bean
    public BeanPostProcessor springfoxHandlerProviderBeanPostProcessor() {
        return generateBeanPostProcessor();
    }

}

