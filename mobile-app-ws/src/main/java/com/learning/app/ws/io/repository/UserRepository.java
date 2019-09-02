package com.learning.app.ws.io.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.learning.app.ws.io.entity.UserEntity;

// extend CrudRepository for no paging
//extend PagingAndSortingRepository for paging
@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {
	 UserEntity findByEmail(String email);
     UserEntity findByUserId(String userId);
}
