package com.movember.quizz.controller.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		authentication.setAuthenticated(true);
		return authentication;
	}

	public boolean supports(Class<? extends Object> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}
}