package com.zipcoder.spacer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpacerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpacerApplication.class, args);
	}
}
