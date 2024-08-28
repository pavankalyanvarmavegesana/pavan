package com.SpringMiniProject.SpringMiniProject.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.SpringMiniProject.SpringMiniProject.dto.PGPlace;
import com.SpringMiniProject.SpringMiniProject.repository.PGPlaceRepository;

@Service
public class PGPlaceService {

    @Autowired
    private PGPlaceRepository pgPlaceRepository;

    public ResponseEntity<PGPlace> addPGPlace(PGPlace pgPlace) {
        return new ResponseEntity<>(pgPlaceRepository.save(pgPlace), HttpStatus.CREATED);
    }

    public ResponseEntity<PGPlace> getPGPlaceDetails(Long id) {
        return pgPlaceRepository.findById(id)
            .map(pgPlace -> new ResponseEntity<>(pgPlace, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<PGPlace> updatePGPlace(Long id, PGPlace pgPlace) {
        if (pgPlaceRepository.existsById(id)) {
            pgPlace.setId(id);
            return new ResponseEntity<>(pgPlaceRepository.save(pgPlace), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> deletePGPlace(Long id) {
        if (pgPlaceRepository.existsById(id)) {
            pgPlaceRepository.deleteById(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<PGPlace>> getPGPlacesByCity(String city) {
        List<PGPlace> pgPlaces = pgPlaceRepository.findByCity(city);
        if (!pgPlaces.isEmpty()) {
            return new ResponseEntity<>(pgPlaces, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<PGPlace>> getPGPlacesByLocality(String locality) {
        List<PGPlace> pgPlaces = pgPlaceRepository.findByLocality(locality);
        if (!pgPlaces.isEmpty()) {
            return new ResponseEntity<>(pgPlaces, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<PGPlace> changeStatus(Long id, boolean status) {
        return pgPlaceRepository.findById(id)
            .map(pgPlace -> {
                pgPlace.setAvailability(status);
                return new ResponseEntity<>(pgPlaceRepository.save(pgPlace), HttpStatus.OK);
            })
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}

