package com.tcc.secureauthserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;

@SpringBootApplication
public class SecureAuthServerApplication extends AuthorizationServerConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication.run(SecureAuthServerApplication.class, args);
	}
	
}
