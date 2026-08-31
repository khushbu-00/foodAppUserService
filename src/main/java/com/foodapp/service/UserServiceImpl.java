package com.foodapp.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.foodapp.dto.OrderDTO;
import com.foodapp.entity.User;
import com.foodapp.exception.InvalidUserDataException;
import com.foodapp.exception.UserNotFoundException;
import com.foodapp.feign.OrderClient;
import com.foodapp.repository.UserRepository;

import jakarta.persistence.criteria.Order;
import jakarta.transaction.Transactional;

	@Service
	public class UserServiceImpl implements UserService {

		@Autowired
		private OrderClient orderClient;
		
		
		@Autowired
		UserRepository userrepository;

		@Override
		public User registerUser(User users) {
			return userrepository.save(users);
		}

		@Override
		public User getUserById(Integer id) {
			return userrepository.findById(id).orElseThrow(() -> new UserNotFoundException("User Not Found"));
		}

		@Override
		public List<User> getAllUsers() {
			return userrepository.findAll();
		}

		@Override
		public User updateUser(Integer id, User user) {
			User existingUser = userrepository.findById(id)
					.orElseThrow(() -> new InvalidUserDataException("Invalid User Data :" + id));
			existingUser.setName(user.getName());
			existingUser.setEmail(user.getEmail());
			existingUser.setPhonenumber(user.getPhonenumber());
			existingUser.setAddress(user.getAddress());

			return userrepository.save(existingUser);
		}

		@Override
		public User deleteUser(Integer id) {
			User extistingUser = userrepository.findById(id).orElseThrow(() -> new UserNotFoundException("User Not Found"));
			userrepository.delete(extistingUser);
			return extistingUser;
		}

		@Override
		public User getUserByEmail(String email) {
			return userrepository.findByEmail(email)
					.orElseThrow(() -> new UserNotFoundException("User not Found with email:" + email));

		}

		@Override
		public User getUserByPhoneNumber(String phonenumber) {
			return userrepository.findByPhonenumber(phonenumber)
					.orElseThrow(() -> new UserNotFoundException("User not Found with phonenumber:"+phonenumber));
		}

		@Override
		public List<User> getUserByName(String name) {
			List<User> users= userrepository.findUserByName(name);
			if(users.isEmpty()) {
				throw new UserNotFoundException("User Not Found With Name :"+name);
			}
			return users;
					
			
		}
		
		//------- for orders ---------
		
		public List<OrderDTO> getAllOrders(){
			return orderClient.getAllOrders();
		}
		

	}

