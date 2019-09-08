package com.learning.app.ws.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.learning.app.ws.exceptions.UserServiceExceptions;
import com.learning.app.ws.io.entity.UserEntity;
import com.learning.app.ws.io.repository.UserRepository;
import com.learning.app.ws.service.UserService;
import com.learning.app.ws.ui.model.response.ErrorMessage;
import com.learning.app.ws.ui.model.response.ErrorMessages;
import com.learning.app.ws.ui.model.response.UserResponse;
import com.learning.app.ws.ui.shared.Utils;
import com.learning.app.ws.ui.shared.dto.AddressDTO;
import com.learning.app.ws.ui.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	Utils utils;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UserDto createUser(UserDto user) {
		
		if(userRepository.findByEmail(user.getEmail())!=null) throw new RuntimeException("Record Already Exist");
		
 		
		for(int pos = 0; pos < user.getAddresses().size();pos++) 
		{
			AddressDTO address = user.getAddresses().get(pos);
			address.setUserDetails(user);
			address.setAddressId(utils.generateAddressId(30));
			user.getAddresses().set(pos, address);
		}
		
		//BeanUtils.copyProperties(userDto, entity);
		ModelMapper modelMapper = new ModelMapper();
		
 
 		UserEntity entity = modelMapper.map(user, UserEntity.class);		
		entity.setUserId(utils.generateUserId(30));		
		entity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		 
	  
//		UserDto returnValue = new UserDto();
		
		UserEntity storedUserDetails = userRepository.save(entity);
		UserDto returnValue = modelMapper.map(storedUserDetails, UserDto.class);

	//	BeanUtils.copyProperties(userEntity, returnValue);
		
		return returnValue;
	}

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserEntity entity = userRepository.findByEmail(username);
		if(entity==null) throw new UsernameNotFoundException(username);
		return new User(entity.getEmail(),entity.getEncryptedPassword(),new ArrayList<>());
	}


	@Override
	public UserDto getUser(String email) {
		UserEntity entity = userRepository.findByEmail(email);
		
		if(entity==null) throw new UserServiceExceptions(ErrorMessages.NO_RECORDS_FOUND.getErrorMessage());
		
		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(entity, returnValue);
		return returnValue;
	}


	@Override
	public UserDto getUserByUserId(String userId) {
		UserEntity entity = userRepository.findByUserId(userId);

		if(entity==null) throw new UserServiceExceptions(ErrorMessages.NO_RECORDS_FOUND.getErrorMessage());

 
		ModelMapper modelMapper = new ModelMapper();
		UserDto returnValue = modelMapper.map(entity, UserDto.class);		

//		BeanUtils.copyProperties(entity, returnValue);

		// TODO Auto-generated method stub
		return returnValue;
	}


	@Override
	public UserDto updateUser(String id,UserDto userDto) {
		// TODO Auto-generated method stub
		UserEntity databaseEntity = userRepository.findByUserId(id);

		if(databaseEntity==null) throw new UserServiceExceptions(ErrorMessages.NO_RECORDS_FOUND.getErrorMessage());

		databaseEntity.setFirstName(userDto.getFirstName());
		databaseEntity.setLastName(userDto.getLastName());

		UserEntity updatedUserDetails = userRepository.save(databaseEntity);

		
		ModelMapper modelMapper = new ModelMapper();
		UserDto returnValue = modelMapper.map(updatedUserDetails, UserDto.class);
		

//		BeanUtils.copyProperties(updatedUserDetails, returnValue);

		return returnValue;
	}


	@Override
	public void deleteUserByUserId(String userId) {
		UserEntity entity = userRepository.findByUserId(userId);

		if(entity==null) throw new UserServiceExceptions(ErrorMessages.NO_RECORDS_FOUND.getErrorMessage());	
		userRepository.delete(entity);
	}


	@Override
	public List<UserDto> getUsers(int page, int limit) {
		List<UserDto> returnVal = new ArrayList<>();
		
		Pageable pageable = PageRequest.of(page,limit);
		Page<UserEntity> userPage = userRepository.findAll(pageable);
		List<UserEntity> users = userPage.getContent();
		
		for(UserEntity entity : users) {
//			UserDto dto = new UserDto();
			UserDto dto = new ModelMapper().map(entity, UserDto.class);	
//			BeanUtils.copyProperties(entity, dto);
			returnVal.add(dto);
		}
		
		// userRepository.findAll(); to return all data
		
		return returnVal;
	} 
}
