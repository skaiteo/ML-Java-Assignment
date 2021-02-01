package com.kai.mljavaassignment.repository;

import java.util.Optional;

import com.kai.mljavaassignment.model.Feature;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Integer> {
    Optional<Feature> findFeatureByName(String name);
}
