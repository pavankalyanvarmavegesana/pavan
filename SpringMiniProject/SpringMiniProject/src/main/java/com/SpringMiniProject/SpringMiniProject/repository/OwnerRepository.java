package com.SpringMiniProject.SpringMiniProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringMiniProject.SpringMiniProject.dto.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    Owner findByPhoneAndPassword(String phone, String password);
}


