package com.SpringMiniProject.SpringMiniProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringMiniProject.SpringMiniProject.dto.Tenant;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {
    Tenant findByEmailAndPassword(String email, String password);
}


