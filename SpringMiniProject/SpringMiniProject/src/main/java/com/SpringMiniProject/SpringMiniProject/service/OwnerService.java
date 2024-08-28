package com.SpringMiniProject.SpringMiniProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.SpringMiniProject.SpringMiniProject.dto.Owner;
import com.SpringMiniProject.SpringMiniProject.dto.PGPlace;
import com.SpringMiniProject.SpringMiniProject.repository.OwnerRepository;
import com.SpringMiniProject.SpringMiniProject.repository.PGPlaceRepository;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private PGPlaceRepository pgPlaceRepository;

    public ResponseEntity<Owner> saveOwner(Owner owner) {
        return new ResponseEntity<>(ownerRepository.save(owner), HttpStatus.CREATED);
    }

    public ResponseEntity<Owner> updateOwner(Owner owner) {
        if (ownerRepository.existsById(owner.getId())) {
            return new ResponseEntity<>(ownerRepository.save(owner), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Owner> findById(Long id) {
        return ownerRepository.findById(id)
            .map(owner -> new ResponseEntity<>(owner, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<Owner> verifyOwner(String phone, String password) {
        Owner owner = ownerRepository.findByPhoneAndPassword(phone, password);
        if (owner != null) {
            return new ResponseEntity<>(owner, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    public ResponseEntity<List<PGPlace>> getOwnerPGPlaces(Long ownerId) {
        List<PGPlace> pgPlaces = pgPlaceRepository.findAll(); // This should ideally filter by ownerId
        if (!pgPlaces.isEmpty()) {
            return new ResponseEntity<>(pgPlaces, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}


