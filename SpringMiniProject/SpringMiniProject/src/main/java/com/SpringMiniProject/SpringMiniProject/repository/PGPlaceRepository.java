package com.SpringMiniProject.SpringMiniProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringMiniProject.SpringMiniProject.dto.PGPlace;

@Repository
public interface PGPlaceRepository extends JpaRepository<PGPlace, Long> {
    List<PGPlace> findByCity(String city);
    List<PGPlace> findByLocality(String locality);
}


