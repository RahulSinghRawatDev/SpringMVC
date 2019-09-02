package com.learning.app.ws.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.learning.app.ws.ui.shared.dto.UserDto;

public interface UserService extends UserDetailsService{
   UserDto createUser(UserDto userDto);	 
   UserDto getUser(String email);
   UserDto getUserByUserId(String id);
   UserDto updateUser(String id,UserDto userDto);
   void deleteUserByUserId(String id);
   List<UserDto> getUsers(int page,int limit);
}
