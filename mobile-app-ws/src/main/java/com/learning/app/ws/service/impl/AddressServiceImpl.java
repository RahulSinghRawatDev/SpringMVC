package com.learning.app.ws.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.app.ws.io.entity.AddressEntity;
import com.learning.app.ws.io.entity.UserEntity;
import com.learning.app.ws.io.repository.AddressRepository;
import com.learning.app.ws.io.repository.UserRepository;
import com.learning.app.ws.service.AddressService;
import com.learning.app.ws.ui.shared.dto.AddressDTO;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	AddressRepository addressRepository;

	@Override
	public List<AddressDTO> getAddresses(String userId) {
		// TODO Auto-generated method stub
		List<AddressDTO> returnValue = new ArrayList<AddressDTO>();
		ModelMapper modelMapper = new ModelMapper();
		
		UserEntity userEntity = userRepository.findByUserId(userId);

 		  if (userEntity == null) return returnValue;
		  

		Iterable<AddressEntity> addresses = addressRepository.findAllByUserDetails(userEntity);

		for (AddressEntity addressEntity : addresses) {
			returnValue.add(modelMapper.map(addressEntity,AddressDTO.class));
		}

		return returnValue;
	}

	@Override
	public AddressDTO getAddress(String addressId) {
		ModelMapper modelMapper = new ModelMapper();		
		AddressEntity addressEntity = addressRepository.findByAddressId(addressId);
		AddressDTO response = null;
		if(addressEntity!=null) {
			response = modelMapper.map(addressEntity, AddressDTO.class);
		}
		return response;
	}

}
