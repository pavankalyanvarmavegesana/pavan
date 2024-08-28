package com.SpringMiniProject.SpringMiniProject.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SpringMiniProject.SpringMiniProject.dto.PGPlace;
import com.SpringMiniProject.SpringMiniProject.service.PGPlaceService;

@RestController
@RequestMapping("/pg")
public class PGPlaceController {

    @Autowired
    private PGPlaceService pgPlaceService;

    
    
    //Important
    @PostMapping("/add")
    public ResponseEntity<PGPlace> addPGPlace(@RequestBody PGPlace pgPlace) {
        return pgPlaceService.addPGPlace(pgPlace);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<PGPlace> getPGPlaceDetails(@PathVariable Long id) {
        return pgPlaceService.getPGPlaceDetails(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PGPlace> updatePGPlace(@PathVariable Long id, @RequestBody PGPlace pgPlace) {
        return pgPlaceService.updatePGPlace(id, pgPlace);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePGPlace(@PathVariable Long id) {
        return pgPlaceService.deletePGPlace(id);
    }
    
    
   //Important
    @GetMapping("/city/{city}")
    public ResponseEntity<List<PGPlace>> getPGPlacesByCity(@PathVariable String city) {
        return pgPlaceService.getPGPlacesByCity(city);
    }
    
    
    //Important
    @GetMapping("/locality/{locality}")
    public ResponseEntity<List<PGPlace>> getPGPlacesByLocality(@PathVariable String locality) {
        return pgPlaceService.getPGPlacesByLocality(locality);
    }

    @PutMapping("/{id}/status/{status}")
    public ResponseEntity<PGPlace> changeStatus(@PathVariable Long id, @PathVariable boolean status) {
        return pgPlaceService.changeStatus(id, status);
    }
}



