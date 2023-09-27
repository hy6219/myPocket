package com.wallet.myPocket;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest
class MyPocketApplicationTests {

	@Autowired
	private Environment environment;
	
	@Test
	void contextLoads() {
		 String key = environment.getProperty("ex-api-key");  
		 String host = environment.getProperty("ex-host");  
	     
		 System.out.println("key: "+key+", host: "+host);
	}

}
