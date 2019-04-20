package com.tcc.secureauthserver.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.secureauthserver.dto.TokenDto;
import com.tcc.secureauthserver.dto.UserDto;

@RestController
public class LoginController {

    private static final Logger logger = LogManager.getLogger(LoginController.class);
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ResponseEntity<TokenDto> getAuthenticationToken(@RequestBody UserDto dto) {
		logger.info("Info log");
		ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
		resourceDetails.setClientAuthenticationScheme(AuthenticationScheme.header);
		resourceDetails.setClientId("secureserver");
		resourceDetails.setClientSecret("secureserversecret");
		resourceDetails.setUsername(dto.getUsername());
		resourceDetails.setPassword(dto.getPassword());
		resourceDetails.setAccessTokenUri("http://localhost:9000/security/oauth/token");
		OAuth2RestTemplate template = new OAuth2RestTemplate(resourceDetails);
		TokenDto postDto = new TokenDto();
		postDto.setToken(template.getAccessToken().getValue());
		return new ResponseEntity<>(postDto, HttpStatus.CREATED);
	}
}
