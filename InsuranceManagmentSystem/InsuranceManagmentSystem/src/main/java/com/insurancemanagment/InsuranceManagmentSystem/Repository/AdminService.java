package com.insurancemanagment.InsuranceManagmentSystem.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.insurancemanagment.InsuranceManagmentSystem.Service.AdminRepository;
import com.insurancemanagment.InsuranceManagmentSystem.Service.UserRepository;
import com.insurancemanagment.InsuranceManagmentSystem.dto.Admin;

@Service
public class AdminService {
	@Autowired
 private AdminRepository adminRepository;
	
	@Autowired
	 private UserRepository userRepository;
	

	public ResponseEntity<Admin> saveAdmin(Admin admin) {
		
		adminRepository.save(admin);
		return new ResponseEntity<Admin>( HttpStatus.CREATED);
	}

	public ResponseEntity<Admin> updateAdmin(Admin admin) {
		adminRepository.save(admin);
		return new ResponseEntity<Admin>( HttpStatus.OK);
	}

	public ResponseEntity<Admin> findbyid(int id) {
		
		return null;
	}
	
public ResponseEntity<String> deleteByUSerId(Integer id) {
	     
		userRepository.deleteById(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	public ResponseEntity<Admin> verifyAdmin(long phone, String password) {
		// TODO Auto-generated method stub
		return null;
	}
}
