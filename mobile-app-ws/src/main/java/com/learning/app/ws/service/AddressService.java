package com.learning.app.ws.service;

import java.util.List;

import com.learning.app.ws.ui.shared.dto.AddressDTO;

public interface AddressService {
	List<AddressDTO> getAddresses(String userId);
	AddressDTO getAddress(String addressId);
}
