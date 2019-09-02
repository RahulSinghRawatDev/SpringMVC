package com.learning.app.ws.ui.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learning.app.ws.exceptions.UserServiceExceptions;
import com.learning.app.ws.service.UserService;
import com.learning.app.ws.ui.model.response.ErrorMessages;
import com.learning.app.ws.ui.model.response.OperationStatusModel;
// RestController -  annotation tells that this class is controller class
// @RequestMapping - this method provides request file
import com.learning.app.ws.ui.model.response.UserResponse;
import com.learning.app.ws.ui.shared.dto.UserDto;

import com.learning.app.ws.ui.model.request.*;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {

	@Autowired
	UserService userService;

	// get request

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public UserResponse getUser(@PathVariable String id) {
		System.out.println("<<<<<Request>>>>>" + id);

		UserResponse response = new UserResponse();
		UserDto createdUser = userService.getUserByUserId(id);

		BeanUtils.copyProperties(createdUser, response);
		System.out.println("");
		System.out.println("<<<<Response>>>>" + response);

		return response;

	}

	// post request
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public UserResponse createUser(@RequestBody UserDatailsRequestModel userDetails) throws Exception {
		System.out.println("<<<<<Request>>>>>" + userDetails.toString());

		UserResponse response = new UserResponse();

//		if(userDetails.getFirstName().isEmpty()) throw new UserServiceExceptions(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
		if (userDetails.getFirstName().isEmpty())
			throw new Exception(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
		if (userDetails.getLastName().isEmpty())
			throw new Exception(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
		if (userDetails.getPassword().isEmpty())
			throw new Exception(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);

		UserDto createdUser = userService.createUser(userDto);
		BeanUtils.copyProperties(createdUser, response);
		System.out.println("");
		System.out.println("<<<<Response>>>>" + response);

		return response;
	}

	// Put request

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public UserResponse updateUser(@PathVariable String id, @RequestBody UserDatailsRequestModel userDetails)
			throws Exception {

		System.out.println("<<<<<Request>>>>>" + id + "...data..." + userDetails.toString());

		UserResponse response = new UserResponse();

		if (userDetails.getFirstName().isEmpty())
			throw new Exception(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
		if (userDetails.getLastName().isEmpty())
			throw new Exception(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());

		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);

		UserDto createdUser = userService.updateUser(id, userDto);
		BeanUtils.copyProperties(createdUser, response);
		System.out.println("");
		System.out.println("<<<<Response>>>>" + response);

		return response;

	}

	// delete request
	@DeleteMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public OperationStatusModel deleteUser(@PathVariable String id) {
		OperationStatusModel response = new OperationStatusModel();
		response.setOperationName("Delete");

		userService.deleteUserByUserId(id);

		response.setOperationResult("Success");
		return response;
	}

	// Get list of users
	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<UserResponse> getUsers(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "25") int limit) {
		
		List<UserResponse> returnValue = new ArrayList<>();
		List<UserDto> users = userService.getUsers(page,limit);
		
		for(UserDto userDto: users) {
			UserResponse response = new UserResponse();
			BeanUtils.copyProperties(userDto, response);
			returnValue.add(response);	
		}
		
		return returnValue;
	}
}
