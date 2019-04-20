package com.tcc.secureauthserver;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;

@Configuration
public class ServiceConfig extends GlobalAuthenticationConfigurerAdapter{

	// TODO: Move this in memory authenticators to a database
	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("User1").password("{noop}pass1").roles("USER").and()
		.withUser("User2").password("{noop}pass2").roles("USER", "ADMIN");
	}
}
