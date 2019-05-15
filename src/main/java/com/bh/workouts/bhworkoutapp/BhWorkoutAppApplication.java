package com.bh.workouts.bhworkoutapp;

/*
Andrii Maliuta
January 2019
 */

import com.bh.workouts.bhworkoutapp.config.ProPTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ProPTest.class)
public class BhWorkoutAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(BhWorkoutAppApplication.class, args);

	}

}
