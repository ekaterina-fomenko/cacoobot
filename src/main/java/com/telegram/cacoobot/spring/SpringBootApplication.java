package com.telegram.cacoobot.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@org.springframework.boot.autoconfigure.SpringBootApplication
@EnableScheduling
public class SpringBootApplication {

    public static void runSpringBoot() throws Exception {
        SpringApplication.run(SpringBootApplication.class);
    }
}

