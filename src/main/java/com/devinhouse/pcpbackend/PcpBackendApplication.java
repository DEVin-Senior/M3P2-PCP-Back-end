package com.devinhouse.pcpbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class PcpBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PcpBackendApplication.class, args);
	}

}
