package com.learning.app.ws.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.learning.app.ws.io.entity.UserEntity;
import com.learning.app.ws.io.repository.UserRepository;

class UserServiceImpTest {
	
	UserServiceImpl userService;

	@Mock
	UserRepository userRepository;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetUser() {
		UserEntity entity = new UserEntity();
		entity.setId(1L);
		entity.setFirstName("ramu");
		entity.setUserId("fdaf");
		entity.setEncryptedPassword("wrr242r1");
		
		
		when(userRepository.findByEmail(anyString())).thenReturn(null);
		fail("Not yet implemented");
	}

}