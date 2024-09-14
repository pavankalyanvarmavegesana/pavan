package com.insurancemanagment.InsuranceManagmentSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.insurancemanagment.InsuranceManagmentSystem.Service.PoliciesService;
import com.insurancemanagment.InsuranceManagmentSystem.dto.Policies;

@RestController
public class PoliciesController {

	@Autowired
	 private PoliciesService policiesService;
	
	
	 //View all policy that are added by admin
		@PostMapping(value = "/addpolices/{adminId}")
		public ResponseEntity<Policies > addPolices(@PathVariable int  adminId,@RequestBody Policies policy) {
			return policiesService.addPolices(adminId,policy);
		}
		
    //View all policy that are added by admin
	@GetMapping(value = "/polices")
	public ResponseEntity<List<Policies>> getAllPolices() {
		return policiesService.getAllPolices();
	}
}
