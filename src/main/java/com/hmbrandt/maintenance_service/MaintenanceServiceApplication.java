package com.hmbrandt.maintenance_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MaintenanceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaintenanceServiceApplication.class, args);
	}

}
