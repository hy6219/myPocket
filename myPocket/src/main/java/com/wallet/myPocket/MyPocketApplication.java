package com.wallet.myPocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class MyPocketApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyPocketApplication.class, args);
	}

}
