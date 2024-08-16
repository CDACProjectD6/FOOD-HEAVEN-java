package com.app.services;

import org.springframework.stereotype.Service;

import com.app.entity.User;


public interface UserService {
	public User findUserByJwtToken(String jwt) throws Exception;

	public User findUserByEmail(String email) throws Exception;

}
