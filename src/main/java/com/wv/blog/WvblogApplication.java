package com.wv.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class WvblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(WvblogApplication.class, args);
	}

}
