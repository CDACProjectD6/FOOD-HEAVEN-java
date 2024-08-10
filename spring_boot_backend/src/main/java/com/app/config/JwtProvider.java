package com.app.config;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.security.Keys;

@Service
public class JwtProvider {

	private SecretKey key= Keys.hmacShaKeyFor(JwtConstant.SECRETE_KEY.getBytes());
	
	public String generateToken(Authentication auth) {
		
	}
}
