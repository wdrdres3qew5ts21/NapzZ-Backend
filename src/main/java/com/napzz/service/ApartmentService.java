package com.napzz.service;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.napzz.entity.Apartment;

@ApplicationScoped
public class ApartmentService {

    @Inject
    private ApartmentRepository apartmentRepository;


    public Optional<Apartment> findByAprtmentId(int apartmentId) {
        return null;
    }

    

}
