package com.insurancemanagment.InsuranceManagmentSystem.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.insurancemanagment.InsuranceManagmentSystem.Repository.PoliciesRepository;
import com.insurancemanagment.InsuranceManagmentSystem.Repository.PolicyBookingRepository;
import com.insurancemanagment.InsuranceManagmentSystem.Repository.UserRepository;
import com.insurancemanagment.InsuranceManagmentSystem.dto.Policies;
import com.insurancemanagment.InsuranceManagmentSystem.dto.PolicyBooking;
import com.insurancemanagment.InsuranceManagmentSystem.dto.User;
@Service
public class PolicyBookingService  {
	
	@Autowired
	private PolicyBookingRepository policyBookingRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PoliciesRepository policiesRepository;

	public ResponseEntity<PolicyBooking> policyRegister(PolicyBooking policy, int userId, int policyId) {
		Optional<User> user=userRepository.findById(userId);
		Optional<Policies> policyDetails=policiesRepository.findById(policyId);
		if(user.isPresent() && policyDetails.isPresent()) {
			User u=user.get();
			Policies p=policyDetails.get();
//			policy.set
			u.getPolicyBookings().add(policy);
			p.getPolicybooking().add(policy);
			policy.setUser(u);
			policy.setPolicies(p);
			userRepository.save(u);
			policiesRepository.save(p);
			return new ResponseEntity<PolicyBooking>(HttpStatus.CREATED);
		}
	  return new ResponseEntity<PolicyBooking>(HttpStatus.BAD_REQUEST);
	}

	
	
}
