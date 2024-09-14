package com.insurancemanagment.InsuranceManagmentSystem.Service;

import java.util.List;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.insurancemanagment.InsuranceManagmentSystem.Repository.UserRepository;
import com.insurancemanagment.InsuranceManagmentSystem.dto.Admin;
import com.insurancemanagment.InsuranceManagmentSystem.dto.Policies;
import com.insurancemanagment.InsuranceManagmentSystem.dto.PolicyBooking;
import com.insurancemanagment.InsuranceManagmentSystem.dto.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public ResponseEntity<User> saveUser(User user) {
		userRepository.save(user);
		return new ResponseEntity<User>(HttpStatus.CREATED);
	}

	public ResponseEntity<List<PolicyBooking>> getAllPolicyBookings(int id) {
		List<PolicyBooking> listPolicyBooking = userRepository.findPolicyBookings(id);
		return new ResponseEntity<List<PolicyBooking>>(listPolicyBooking, HttpStatus.OK);
	}

	public ResponseEntity<List<Question>> getQuestions(int userid) {
		List<Question> listQuestion = userRepository.findQuestionsByUserId(userid);
		return new ResponseEntity<List<Question>>(listQuestion, HttpStatus.OK);	}
}
