package com.clinic.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.clinic.provider.mapper")
public class ClinicProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClinicProviderApplication.class, args);
    }

}
