package com.wallet.myPocket.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExercisedbConfig {
	@Value("${exercisedb.api-key}")
	private String apiKey;
	@Value("${exercisedb.host}")
	private String host;
	
	public String getApiKey() {
		return apiKey;
	}
	public String getHost() {
		return host;
	}
	
	
}
