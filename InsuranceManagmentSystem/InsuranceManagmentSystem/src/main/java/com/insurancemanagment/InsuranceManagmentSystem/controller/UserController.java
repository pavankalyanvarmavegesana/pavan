package com.insurancemanagment.InsuranceManagmentSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insurancemanagment.InsuranceManagmentSystem.Repository.AdminService;
import com.insurancemanagment.InsuranceManagmentSystem.Repository.UserService;
import com.insurancemanagment.InsuranceManagmentSystem.dto.Admin;
import com.insurancemanagment.InsuranceManagmentSystem.dto.User;

@RestController
public class UserController {

	@Autowired
	 private UserService userService;

	@PostMapping(value = "/user/add")
	public ResponseEntity<User> saveAdmin(@RequestBody User user) {
		return userService.saveUser(user);
	}
}
