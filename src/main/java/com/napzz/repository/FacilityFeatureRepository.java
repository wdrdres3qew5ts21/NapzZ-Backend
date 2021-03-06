package com.napzz.repository;

import com.napzz.entity.asset.FacilityFeature;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilityFeatureRepository extends JpaRepository<FacilityFeature, Integer>{

}
