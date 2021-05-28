package com.napzz.repository;

import java.util.List;

import com.napzz.entity.Apartment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Integer> {

    List<Apartment> findByNameContains(String apartmentName);

    List<Apartment> findByLocationProvinceContains(String province);

    List<Apartment> findByNameContainsAndLocationProvinceContains(String apartmentName, String province);

    List<Apartment> findByDescriptionContains(String apartmentName);

}
