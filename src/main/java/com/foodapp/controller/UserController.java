package com.foodapp.controller;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.dto.OrderDTO;
import com.foodapp.entity.User;
import com.foodapp.service.UserService;

import jakarta.transaction.Transactional;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userservice;

	public UserController() {
		System.out.println("-----Ready to exceute----");
	}
	
    @Transactional
	@PostMapping("")
	public ResponseEntity<User> registerUser(@RequestBody User users) {

		logger.info("Create user Request API CAlled");
		User savedRegisterUser = userservice.registerUser(users);
		return new ResponseEntity<>(savedRegisterUser, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer id) {
		logger.info("Status API Called for Request Id{}");
		return ResponseEntity.ok(userservice.getUserById(id));

	}

	@GetMapping("")
	public ResponseEntity<List<User>> getAllUsers() {
		logger.info("Status API Called for All Users");
		return ResponseEntity.ok(userservice.getAllUsers());

	}

	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user) {
		logger.info("Status API Called for All updateUsers");
		return ResponseEntity.ok(userservice.updateUser(id, user));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id){
		logger.info("Delete user with id");
	userservice.deleteUser(id);
	return ResponseEntity.ok("User Deleted Successfully");
	
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable String email){
		logger.info("Status API Called for UserbyEmail");
		return ResponseEntity.ok(userservice.getUserByEmail(email));
	}
	
	@GetMapping("phone/{phone}")
	public ResponseEntity<User> getUserByPhoneNumber(@PathVariable String phonenumber){
		logger.info("Status API Called for UserbyPhoneNumber");
		return ResponseEntity.ok(userservice.getUserByPhoneNumber(phonenumber));
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity <List<User>> getUserByName(@PathVariable String name){
		logger.info("Status API Called for UserbyName");
		return ResponseEntity.ok(userservice.getUserByName(name));
	}
	
	
	
	//------> for orders------>
	
	@GetMapping("orders")
	public ResponseEntity<List<OrderDTO>> getAllOrders(){
		logger.info("Status API Called for getAllOrders Of Users");
		return ResponseEntity.ok(userservice.getAllOrders());
		
	}
}


