package com.SpringMiniProject.SpringMiniProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.SpringMiniProject.SpringMiniProject.dto.Tenant;
import com.SpringMiniProject.SpringMiniProject.repository.TenantRepository;

@Service
public class TenantService {

    @Autowired
    private TenantRepository tenantRepository;

    public ResponseEntity<Tenant> saveTenant(Tenant tenant) {
        return new ResponseEntity<>(tenantRepository.save(tenant), HttpStatus.CREATED);
    }

    public ResponseEntity<Tenant> findById(Long id) {
        return tenantRepository.findById(id)
            .map(tenant -> new ResponseEntity<>(tenant, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<Tenant> verifyTenant(String email, String password) {
        Tenant tenant = tenantRepository.findByEmailAndPassword(email, password);
        if (tenant != null) {
            return new ResponseEntity<>(tenant, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
