package com.awareness.ApiWithJWT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@EntityScan(
		basePackageClasses = {
				ApiWithJwtApplication.class,
				Jsr310JpaConverters.class
		}
)
public class ApiWithJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiWithJwtApplication.class, args);
	}

	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
}
