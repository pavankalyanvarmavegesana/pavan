package com.insurancemanagment.InsuranceManagmentSystem.controller;

import java.util.List;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insurancemanagment.InsuranceManagmentSystem.Service.UserService;
import com.insurancemanagment.InsuranceManagmentSystem.dto.Policies;
import com.insurancemanagment.InsuranceManagmentSystem.dto.PolicyBooking;
import com.insurancemanagment.InsuranceManagmentSystem.dto.User;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/user/add")
	public ResponseEntity<User> saveAdmin(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
    //Customer can check status of his policy under history section.
	@GetMapping(value = "/policybookings/{userid}")
	public ResponseEntity<List<PolicyBooking>> getAllPolices(@PathVariable int userid) {
		return userService.getAllPolicyBookings(userid);
	}
	
	@GetMapping(value = "/userquestions/{userid}")
	public ResponseEntity<List<Question>> getQuestions(@PathVariable int userid) {
		return userService.getQuestions(userid);
	}
	

}
