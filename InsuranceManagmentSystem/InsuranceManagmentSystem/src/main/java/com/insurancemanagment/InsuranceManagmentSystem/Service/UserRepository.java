package com.insurancemanagment.InsuranceManagmentSystem.Service;

import org.apache.catalina.connector.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import com.insurancemanagment.InsuranceManagmentSystem.dto.Admin;
import com.insurancemanagment.InsuranceManagmentSystem.dto.User;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

	
	
	

	
}
