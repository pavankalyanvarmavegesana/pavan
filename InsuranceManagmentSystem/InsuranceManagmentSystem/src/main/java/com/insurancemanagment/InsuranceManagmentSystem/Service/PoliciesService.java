package com.insurancemanagment.InsuranceManagmentSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.insurancemanagment.InsuranceManagmentSystem.Repository.AdminRepository;
import com.insurancemanagment.InsuranceManagmentSystem.Repository.PoliciesRepository;
import com.insurancemanagment.InsuranceManagmentSystem.dto.Admin;
import com.insurancemanagment.InsuranceManagmentSystem.dto.Policies;

@Service
public class PoliciesService {
	@Autowired
	private PoliciesRepository policiesRepository;
	
	@Autowired
	private AdminRepository adminRepository;

	public ResponseEntity<List<Policies>> getAllPolices() {
		List<Policies> listPolicies=policiesRepository.findAll();
		return new ResponseEntity<List<Policies>>(listPolicies,HttpStatus.OK);
	}

	public ResponseEntity<Policies> addPolices(int adminId, Policies policy) {
		Optional<Admin> admin=adminRepository.findById(adminId);
		if(admin.isPresent()) {
			Admin a=admin.get();
			a.getPolicies().add(policy);
			adminRepository.save(a);
			policy.setAdmin(a);
			policiesRepository.save(policy);
			return new ResponseEntity<Policies>(HttpStatus.CREATED);
		}
		return new ResponseEntity<Policies>(HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	
}
