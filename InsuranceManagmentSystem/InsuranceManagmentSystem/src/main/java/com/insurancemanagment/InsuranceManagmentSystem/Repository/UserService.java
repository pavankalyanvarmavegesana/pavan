package com.insurancemanagment.InsuranceManagmentSystem.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.insurancemanagment.InsuranceManagmentSystem.Service.UserRepository;
import com.insurancemanagment.InsuranceManagmentSystem.dto.Admin;
import com.insurancemanagment.InsuranceManagmentSystem.dto.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public ResponseEntity<User> saveUser(User user) {
		userRepository.save(user);
		return new ResponseEntity<User>( HttpStatus.CREATED);		
	}

}
