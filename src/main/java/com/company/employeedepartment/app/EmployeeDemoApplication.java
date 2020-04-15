package com.company.employeedepartment.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude={MongoAutoConfiguration.class})
@EntityScan("com.company.employeedepartment.entity")
@EnableJpaRepositories("com.company.employeedepartment.dao")
@ComponentScan({"com.company.employeedepartment.converter","com.company.employeedepartment.controller", "com.company.employeedepartment.service", "com.company.employeedepartment.service.impl"})
@EnableCaching
@EnableSwagger2
public class EmployeeDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeDemoApplication.class, args);
    }
}
