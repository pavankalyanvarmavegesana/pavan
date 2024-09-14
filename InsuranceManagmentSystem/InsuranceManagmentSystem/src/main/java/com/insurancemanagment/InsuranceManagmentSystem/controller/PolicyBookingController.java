package com.insurancemanagment.InsuranceManagmentSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insurancemanagment.InsuranceManagmentSystem.Service.PolicyBookingService;
import com.insurancemanagment.InsuranceManagmentSystem.dto.Policies;
import com.insurancemanagment.InsuranceManagmentSystem.dto.PolicyBooking;

@RestController
public class PolicyBookingController {

	
	@Autowired
	private PolicyBookingService policyBookingService;
	@PostMapping(value = "/register/{userId}/{policyId}")
	public ResponseEntity<PolicyBooking>  policyRegister(@PathVariable int userId,@PathVariable int policyId, @RequestBody PolicyBooking policy){
		return policyBookingService.policyRegister(policy,userId,policyId);
	}
	
//	@PostMapping(value="/roombook/accepted/{hotel_id}")
//	public ResponseEntity<PolicyBooking> accepted(@RequestBody PolicyBooking policy){
//		return service.accepetd(room,hotel_id);
//	}
//	
//	
//	@PostMapping(value="/roombook/rejected/{hotel_id}")
//	public ResponseEntity<RoomBook> rejected(@RequestBody RoomBook room,@PathVariable int hotel_id){
//		return service.rejected(room,hotel_id);
//	}
	
	
}
