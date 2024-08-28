package com.SpringMiniProject.SpringMiniProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SpringMiniProject.SpringMiniProject.dto.Owner;
import com.SpringMiniProject.SpringMiniProject.dto.PGPlace;
import com.SpringMiniProject.SpringMiniProject.service.OwnerService;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @PostMapping("/add")
    public ResponseEntity<Owner> saveOwner(@RequestBody Owner owner) {
        return ownerService.saveOwner(owner);
    }

    @PutMapping("/update")
    public ResponseEntity<Owner> updateOwner(@RequestBody Owner owner) {
        return ownerService.updateOwner(owner);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable Long id) {
        return ownerService.findById(id);
    }

    @PostMapping("/verify")
    public ResponseEntity<Owner> verifyOwner(@RequestParam String phone, @RequestParam String password) {
        return ownerService.verifyOwner(phone, password);
    }

    @GetMapping("/{ownerId}/pgplaces")
    public ResponseEntity<List<PGPlace>> getOwnerPGPlaces(@PathVariable Long ownerId) {
        return ownerService.getOwnerPGPlaces(ownerId);
    }
}


