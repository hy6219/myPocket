package com.wallet.myPocket.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfirmConfig {
	@Value("${financial.confirm.clientId}")
	private String clientId;
	@Value("${financial.confirm.clientSecret}")
	private String clientSecret;
}
