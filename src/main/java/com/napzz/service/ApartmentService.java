package com.napzz.service;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.napzz.entity.Apartment;
import com.napzz.repository.ApartmentRepository;

@ApplicationScoped
public class ApartmentService {

    @Inject
    private ApartmentRepository apartmentRepository;


    public Optional<Apartment> findByAprtmentId(int apartmentId) {
        return apartmentRepository.findById(apartmentId);
    }


    public List<Apartment> listApartment() {
        return apartmentRepository.findAll();
    }


    public Apartment createApartment(Apartment apartment) {
        Apartment savedAprtment = apartmentRepository.save(apartment);
        return savedAprtment;
    }



}
