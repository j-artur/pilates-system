package dev.jartur.pilates_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PilatesSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PilatesSystemApplication.class, args);
	}

}
