package com.telegram.cacoobot.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Ekaterina Fomenko
 * @brief This class running spring application
 * @date 6 of December of 2016
 */

@org.springframework.boot.autoconfigure.SpringBootApplication
@EnableScheduling
public class SpringBootApplication {

    public static void runSpringBoot() throws Exception {
        SpringApplication.run(SpringBootApplication.class);
    }
}

