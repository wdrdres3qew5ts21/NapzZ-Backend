package com.napzz.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.constraints.Null;

import com.napzz.entity.Apartment;
import com.napzz.entity.room.Room;
import com.napzz.entity.user.ApartmentOwner;
import com.napzz.repository.ApartmentRepository;

@ApplicationScoped
public class ApartmentService {

    @Inject
    private ApartmentRepository apartmentRepository;

    public Optional<Apartment> findByAprtmentId(int apartmentId) {
         Optional<Apartment> foundedRoom = apartmentRepository.findById(apartmentId);
         Set<Room> roomList = foundedRoom.get().getRoomList();
         System.out.println("======================");
         System.out.println(roomList);
        return foundedRoom;
    }

    public List<Apartment> listApartment(String apartmentName, String province) {
        List<Apartment> foundedApartment = null;
        if (apartmentName == null && province == null) {
            foundedApartment = apartmentRepository.findAll();
        } else if (apartmentName != null) {
            foundedApartment = apartmentRepository.findByNameContains(apartmentName);
        } else if (province != null) {
            foundedApartment = apartmentRepository.findByLocationProvinceContains(province);
        }
        if (foundedApartment.size() == 0) {
            System.out.println("Still Null");
            return apartmentRepository.findByDescriptionContains(apartmentName);
        }
        return foundedApartment;
    }

    public Apartment createApartment(Integer apartmentOwnerId, Apartment apartment) {
        ApartmentOwner apartmentOwner = new ApartmentOwner();
        apartmentOwner.setUserId(apartmentOwnerId);
        apartment.setApartmentOwner(apartmentOwner);
        Apartment savedAprtment = apartmentRepository.save(apartment);
        return savedAprtment;
    }

    public List<Apartment> findByApartmentOwnerUserId(int apartmentOwnerId) {
        return apartmentRepository.findByApartmentOwnerApartmentOwnerId(apartmentOwnerId);
    }

}
