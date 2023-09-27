package com.wallet.myPocket;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.wallet.myPocket.config.ExercisedbConfig;

@TestConfiguration
public class TestConfig implements WebMvcConfigurer{

	@Bean
	public ExercisedbConfig confirmConfig() {
		return new ExercisedbConfig();
	}
}
