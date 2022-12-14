package com.microservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.microservice.dto.UserDto;
import com.microservice.entities.UserEntity;
import com.microservice.repo.UserRepo;
import com.microservice.response.ErrorResponseDto;
import com.microservice.response.SuccessResponseDto;
import com.microservice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepo userRepo;

//	@PostMapping("/admin")
//	public UserEntity addUser(@RequestBody UserEntity user) {
//		return this.userService.addUser(user);
//	}

	@PostMapping("/admin")
	public ResponseEntity<?> addUser(@RequestBody UserEntity user) {

		try {

			UserEntity userEntity = this.userService.addUser(user);

			return new ResponseEntity<>(new SuccessResponseDto("POST", "Data Added Successfully", userEntity),
					HttpStatus.CREATED);

		} catch (Exception e) {

			return new ResponseEntity<>(new ErrorResponseDto("Something Went Wrong", e.getMessage()),
					HttpStatus.NOT_ACCEPTABLE);
		}
	}

//	@GetMapping("/admin")
//	public List<UserEntity> getAllUsers() {
//		return this.userService.getAllUsers();
//	}

	@GetMapping("/admin")
	public ResponseEntity<?> getAllUsers() {

		List<UserEntity> database = this.userRepo.findAll();

		if (database != null) {
			try {

				List<UserEntity> userEntity = this.userService.getAllUsers();

				return new ResponseEntity<>(new SuccessResponseDto("READ", "Get All Data Successfully", userEntity),
						HttpStatus.OK);

			} catch (Exception e) {

				return new ResponseEntity<>(new ErrorResponseDto("Something Went Wrong", e.getMessage()),
						HttpStatus.BAD_REQUEST);
			}

		} else {

			return new ResponseEntity<>(new ErrorResponseDto("Data not Found", "NO CONTENT"), HttpStatus.NO_CONTENT);

		}

	}

//	@GetMapping("/admin/pagination")
//	public List<UserEntity> getAllUsersWithPagination(  @RequestParam Integer pageNumber , @RequestParam Integer pageSize  ) {
//		
//		List<UserEntity> pagination=this.userService.getAllUsersWithPagination(pageNumber, pageSize);
//		return pagination;
//	}

	@GetMapping("/admin/pagination")
	public ResponseEntity<?> getAllUsersWithPagination(@Valid @RequestParam(value = "pageNumber") Integer pageNumber,
			@Valid @RequestParam(value = "pageSize") Integer pageSize) {

		List<UserEntity> database = this.userRepo.findAll();

		if (database != null) {
			try {

				List<UserEntity> pagination = this.userService.getAllUsersWithPagination(pageNumber, pageSize);

				return new ResponseEntity<>(new SuccessResponseDto("READ , PAGINATION",
						"Get All Data With Pagination Successfully", pagination), HttpStatus.OK);

			} catch (Exception e) {

				return new ResponseEntity<>(new ErrorResponseDto("Something Went Wrong", e.getMessage()),
						HttpStatus.BAD_REQUEST);

			}

		} else {

			return new ResponseEntity<>(new ErrorResponseDto("Data not Found", "NO CONTENT"), HttpStatus.NO_CONTENT);

		}

	}

//	@GetMapping("/admin/{id}")
//	public UserEntity getUserById(@RequestParam(value= "id") long id) throws Exception {
//		return this.userService.getUserById(id);
//	}

	@GetMapping("/admin/{id}")
	public ResponseEntity<?> getUserById(@Valid @RequestParam(value = "id") long id) throws Exception {

		List<UserEntity> database = this.userRepo.findAll();

		if (database != null) {

			try {
				UserEntity userEntity = this.userService.getUserById(id);

				return new ResponseEntity<>(new SuccessResponseDto("READ", "Get Data By Id Successfully", userEntity),
						HttpStatus.OK);
			} catch (Exception e) {

				return new ResponseEntity<>(new ErrorResponseDto("Something Went Wrong", e.getMessage()),
						HttpStatus.NOT_FOUND);
			}

		} else {

			return new ResponseEntity<>(new ErrorResponseDto("Data not Found", "NO CONTENT"), HttpStatus.NO_CONTENT);

		}
	}

//	@GetMapping("/admin/name")
//	public List<UserEntity> getUserByName(@RequestParam(value="name") String name) throws Exception {
//		List<UserEntity> getName = this.userService.getUserByName(name);
//		 
//		 return getName;
//	}

	@GetMapping("/admin/name")
	public ResponseEntity<?> getUserByName(@Valid @RequestParam(value = "name") String name) throws Exception {

		List<UserEntity> database = this.userRepo.findAll();

		if (database != null) {
			try {
				List<UserEntity> getName = this.userService.getUserByName(name);

				return new ResponseEntity<>(new SuccessResponseDto("READ", "Get Data By Name Successfully", getName),
						HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(new ErrorResponseDto("Something Went Wrong", e.getMessage()),
						HttpStatus.NOT_FOUND);
			}

		} else {

			return new ResponseEntity<>(new ErrorResponseDto("Data not Found", "NO CONTENT"), HttpStatus.NO_CONTENT);

		}
	}

//	@PutMapping("/admin/{id}")
//	public UserEntity editUserById(@PathVariable(value="id") long id, @RequestBody UserEntity user) throws Exception {
//		return this.userService.editUserById(id, user);
//	}

	@PutMapping("/admin/{id}")
	public ResponseEntity<?> editUserById(@PathVariable(value = "id") long id, @Valid @RequestBody UserEntity user)
			throws Exception {

		List<UserEntity> database = this.userRepo.findAll();

		if (database != null) {
			try {
				UserEntity userEntity = this.userService.editUserById(id, user);

				return new ResponseEntity<>(new SuccessResponseDto("PUT", "Data Updated Successfully", userEntity),
						HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(new ErrorResponseDto("Something Went Wrong", e.getMessage()),
						HttpStatus.NOT_ACCEPTABLE);
			}
		} else {

			return new ResponseEntity<>(new ErrorResponseDto("Data not Found", "NO CONTENT"), HttpStatus.NO_CONTENT);

		}
	}

//	@DeleteMapping("/admin/{id}")
//	public String deleteUserById(@PathVariable(value="id") long id) {
//		this.userService.deleteUserById(id);
//		return "Thank You !!! \nId "+id+" Delete Sucessfully";
//	}

	@DeleteMapping("/admin/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable(value = "id") long id) {

		List<UserEntity> database = this.userRepo.findAll();
		if (database != null) {
			try {
				this.userService.deleteUserById(id);
				return new ResponseEntity<>(
						new SuccessResponseDto("DELETE", "Id " + id + " Delete Sucessfully", "NOT FOUND"),
						HttpStatus.OK);

			} catch (Exception e) {
				return new ResponseEntity<>(new ErrorResponseDto("Something Went Wrong", e.getMessage()),
						HttpStatus.ALREADY_REPORTED);
			}
		} else {

			return new ResponseEntity<>(new ErrorResponseDto("Data not Found", "NO CONTENT"), HttpStatus.NO_CONTENT);

		}
	}

// Dto - User

//	@GetMapping("/")
//	public List<UserDto> getAllUsersUsingDto() {
//
//		List<UserDto> dto = userService.findByAllUsingDto();
//		return dto;
//
//	}

	@GetMapping("/")
	public ResponseEntity<?> getAllUsersUsingDto() {

		List<UserEntity> database = this.userRepo.findAll();

		if (database != null) {
			try {

				List<UserDto> dto = userService.findByAllUsingDto();

				return new ResponseEntity<>(new SuccessResponseDto("READ", "Get All Data Successfully", dto),
						HttpStatus.OK);

			} catch (Exception e) {

				return new ResponseEntity<>(new ErrorResponseDto("Something Went Wrong", e.getMessage()),
						HttpStatus.BAD_REQUEST);
			}

		} else {

			return new ResponseEntity<>(new ErrorResponseDto("Data not Found", "NO CONTENT"), HttpStatus.NO_CONTENT);

		}

	}

//	@GetMapping("/pagination")
//	public List<UserDto> paginationWithDto(  @RequestParam Integer pageNumber , @RequestParam Integer pageSize  ) {
//		
//		List<UserDto> pagination=this.userService.getAllUsersWithPagination(pageNumber, pageSize);
//		return pagination;
//	}

//	@GetMapping("/{id}")
//	public UserDto getByDtoId(@RequestParam(value="id") long id) throws Exception {
//		UserDto userDto = userService.findByIdUsingDto(id);
//		return userDto;
//	} 

	@GetMapping("/{id}")
	public ResponseEntity<?> getByDtoId(@Valid @RequestParam(value = "id") long id) throws Exception {

		List<UserEntity> database = this.userRepo.findAll();

		if (database != null) {

			try {
				UserDto userDto = userService.findByIdUsingDto(id);

				return new ResponseEntity<>(new SuccessResponseDto("READ", "Get Data By Id Successfully", userDto),
						HttpStatus.OK);
				
			} catch (Exception e) {

				return new ResponseEntity<>(new ErrorResponseDto("Something Went Wrong", e.getMessage()),
						HttpStatus.NOT_FOUND);
			}

		} else {

			return new ResponseEntity<>(new ErrorResponseDto("Data not Found", "NO CONTENT"), HttpStatus.NO_CONTENT);

		}

	}

}
