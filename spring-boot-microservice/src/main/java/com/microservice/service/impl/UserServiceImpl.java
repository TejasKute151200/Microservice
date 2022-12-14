package com.microservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.microservice.dto.UserDto;
import com.microservice.entities.UserEntity;
import com.microservice.repo.UserRepo;
import com.microservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserEntity addUser(UserEntity user) {
		
		UserEntity newUser = new UserEntity();
		
		newUser.setId(user.getId());
		newUser.setName(user.getName());
		newUser.setAddress(user.getAddress());
		newUser.setMobile(user.getMobile());
		
		return this.userRepo.save(newUser);
	}

	
	@Override
	public List<UserEntity> getAllUsers() {
		return this.userRepo.findAll(); 
	}
	
	@Override
	public List<UserEntity> getAllUsersWithPagination(Integer pageNumber, Integer pageSize) {
	
		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
		Page<UserEntity> page = this.userRepo.findAll(pageable);
		
		List<UserEntity> list = page.getContent();
		
		return list;	
	}
	
	@Override
	public UserEntity getUserById(long id) throws Exception {
		return this.userRepo.findById(id).orElseThrow(()-> new Exception("User Not Found on Given Id "+id));
	}
	
	@Override
	public List<UserEntity> getUserByName(String name) {
		List<UserEntity> getName = this.userRepo.findByName(name);
		
		return getName;
	}

	@Override
	public UserEntity editUserById(long id, UserEntity user) throws Exception {
		
		UserEntity updateUser = this.userRepo.findById(id).orElseThrow(()-> new Exception("User Not Found on Given Id "+id));
				
		updateUser.setId(user.getId());
		updateUser.setName(user.getName());
		updateUser.setAddress(user.getAddress());
		updateUser.setMobile(user.getMobile());
		
		return this.userRepo.save(updateUser);
	}

	@Override
	public void deleteUserById(long id) {
		this.userRepo.deleteById(id);
	}

	//dto - user

	@Override
	public List<UserDto> findByAllUsingDto() {
		 
		List<UserEntity> user = this.userRepo.findAll(); //take data 
		List<UserDto> dto = new ArrayList<>(); // create list

		for (int i = 0; i < user.size(); i++) {
			
			UserDto userDto = new UserDto();
			userDto.setName(user.get(i).getName());
			userDto.setAddress(user.get(i).getAddress());
			userDto.setMobile(user.get(i).getMobile());
			
			dto.add(userDto);
		}
		
		return dto;
	}

	@Override
	public UserDto findByIdUsingDto(long id) throws Exception {

		UserEntity user = userRepo.findById(id).orElseThrow(() -> new Exception("User Not Found on Given Id "+id));
		
		UserDto userDto = new UserDto();
		
		userDto.setName(user.getName());
		userDto.setAddress(user.getAddress());
		userDto.setMobile(user.getMobile());

		return userDto;	
	}
	
//	@Override
//	public Page<UserDto> paginationWithDto(Integer pageNumber, Integer pageSize) {
//		
//		Pageable paging = new Pageable();
//		List<UserDto> dto = new ArrayList<>(); // create list
//		
//		for (int i = 0; i < user.size(); i++) {
//			
//			UserDto userDto = new UserDto();
//			userDto.setName(user.get(i).getName());
//			userDto.setAddress(user.get(i).getAddress());
//			userDto.setMobile(user.get(i).getMobile());
//			
//			dto.add(userDto);
//		}
//		
//		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
//		Page<UserDto > page = this.userRepo.findAll(pageable);
//		
//		List<UserDto> list = page.getContent();
//	
//		return dto;
//		
//		
//		
//		
//		
//			LOG.info("getAllRoles() >> >> Start");
//			Pageable paging = new PaginationUsingFromTo().getPagination(from, to);
//			Page<IRoleListDto> roles;
//			if (search == "" || search == null || search.length() == 0) {
//				LOG.info("getAllRoles() >> Fetching >> Start");
//				roles = roleRepository.findByOrderByIdDesc(paging, IRoleListDto.class);
//			} else {
//				LOG.info("getAllRoles() >> Fetching >> Start");
//				roles = roleRepository.findByRoleNameAndIsActiveTrue(StringUtils.trimLeadingWhitespace(search), paging, IRoleListDto.class);
//			}
//			return roles;
//		}
//		
//	}
//
//	@Override
//	public List<UserDto> findByNameUsingDto(String name) {
//		
//		List<UserDto> user = this.userRepo.findByNameUsingDto(name);
//
//		return user;
//	}
}
