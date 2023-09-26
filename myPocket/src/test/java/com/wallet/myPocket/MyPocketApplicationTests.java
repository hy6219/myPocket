package com.wallet.myPocket;

import org.junit.jupiter.api.Assertions;
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
		  String clientId= environment.getProperty("financial.confirm.clientId");
		  String clientSecret= environment.getProperty("financial.confirm.clientSecret");
		   
	      Assertions.assertNotNull(clientId);
	      Assertions.assertNotNull(clientSecret);   
	      
	}

}
