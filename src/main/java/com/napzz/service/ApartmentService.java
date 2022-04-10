package com.napzz.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.constraints.Null;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import com.napzz.entity.Apartment;
import com.napzz.entity.room.Room;
import com.napzz.entity.user.ApartmentOwner;
import com.napzz.repository.ApartmentRepository;

@ApplicationScoped
public class ApartmentService {

    @Inject
    private ApartmentRepository apartmentRepository;

    public String anotherHardCode() throws IOException {
        Client build = ClientBuilder.newBuilder().build();
        build.target("77.33.33.134").request().get();
        FileWriter fw = new FileWriter("C:\\ProjectCode\\NapzZ-Backend\\hardcode.log");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("Test Hard Code Endpoint Logging");
        bw.close();
        return  "Really Hard Code 😥😣😣";
    }

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
