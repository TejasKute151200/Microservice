package com.microservice.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.microservice.entities.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {	
	public List<UserEntity> findByName(String name);

//	public List<UserDto> findByNameUsingDto(String name);
	
}
