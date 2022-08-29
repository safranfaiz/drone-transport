package com.safran.dronetransport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class DroneTransportApplication {

	public static void main(String[] args) {
		SpringApplication.run(DroneTransportApplication.class, args);
	}

}
