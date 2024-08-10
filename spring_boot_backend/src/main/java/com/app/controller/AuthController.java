package com.app.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.repository.UserRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private UserRepository userRepository;
	
	private PasswordEncoder passwordEncoder;
	  
}
