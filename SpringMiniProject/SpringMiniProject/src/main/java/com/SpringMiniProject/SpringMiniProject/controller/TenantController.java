package com.SpringMiniProject.SpringMiniProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SpringMiniProject.SpringMiniProject.dto.Tenant;
import com.SpringMiniProject.SpringMiniProject.service.TenantService;

@RestController
@RequestMapping("/tenants")
public class TenantController {

    @Autowired
    private TenantService tenantService;

    @PostMapping
    public ResponseEntity<Tenant> saveTenant(@RequestBody Tenant tenant) {
        return tenantService.saveTenant(tenant);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tenant> getTenantById(@PathVariable Long id) {
        return tenantService.findById(id);
    }

    
    @PostMapping("/verify")
    public ResponseEntity<Tenant> verifyTenant(@RequestParam String email, @RequestParam String password) {
        return tenantService.verifyTenant(email, password);
    }
}


