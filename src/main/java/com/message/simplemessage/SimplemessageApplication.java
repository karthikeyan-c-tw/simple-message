package com.message.simplemessage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.message.simplemessage.repository")
public class SimplemessageApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimplemessageApplication.class, args);
	}

}
