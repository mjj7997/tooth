package com.clinic.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.clinic.provider.mapper")
@ComponentScan(basePackages = "com.clinic")
public class ClinicProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClinicProviderApplication.class, args);
    }

}
