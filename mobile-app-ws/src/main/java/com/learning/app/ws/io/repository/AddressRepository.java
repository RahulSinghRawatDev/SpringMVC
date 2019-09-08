package com.learning.app.ws.io.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.learning.app.ws.io.entity.AddressEntity;
import com.learning.app.ws.io.entity.UserEntity;

// extend CrudRepository for no paging
//extend PagingAndSortingRepository for paging
@Repository
public interface AddressRepository extends CrudRepository<AddressEntity,Long> {
	 List<AddressEntity> findAllByUserDetails(UserEntity entity);
	 AddressEntity findByAddressId(String addressId);
	 
}
