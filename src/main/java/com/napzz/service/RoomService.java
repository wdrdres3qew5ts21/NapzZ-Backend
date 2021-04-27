package com.napzz.service;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.napzz.entity.asset.FacilityFeature;
import com.napzz.entity.asset.LandmarkFeature;
import com.napzz.entity.room.Room;
import com.napzz.repository.FacilityFeatureRepository;
import com.napzz.repository.RoomRepository;

@ApplicationScoped
public class RoomService {

    @Inject
    private RoomRepository roomRepository;

    @Inject
    private LandmarkFeatureRepository landmarkFeatureRepository;

    @Inject 
    private FacilityFeatureRepository facilityFeatureRepository;

    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    public Optional<Room> findRoomById(int roomId) {
        return roomRepository.findById(roomId);
    }

    public List<Room> listRoom() {
        return roomRepository.findAll();
    }

    public FacilityFeature createFacilityFeature(FacilityFeature facilityFeature) {
        FacilityFeature createdFacilityFeature = facilityFeatureRepository.save(facilityFeature);
        return createdFacilityFeature;

    }

    public LandmarkFeature createLandmarkFeature(LandmarkFeature landmarkFeature) {
        return landmarkFeatureRepository.save(landmarkFeature);
    }

    public void init() {
        LandmarkFeature landmarkFeature1 = new LandmarkFeature(1,"บริการขนส่งสาธารณะในระยะ 400 เมตร");
        LandmarkFeature landmarkFeature2 = new LandmarkFeature(2,"Wifi Free Whole Apartment");
        LandmarkFeature landmarkFeature3 = new LandmarkFeature(3,"Gym Maxxing");
        landmarkFeatureRepository.save(landmarkFeature1);
        landmarkFeatureRepository.save(landmarkFeature2);
        landmarkFeatureRepository.save(landmarkFeature3);

        FacilityFeature facilityFeature1 = new FacilityFeature(1, "Two Bed");
        FacilityFeature facilityFeature2 = new FacilityFeature(2, "Elagant Vantage");
        FacilityFeature facilityFeature3 = new FacilityFeature(3, "No Smoking");
        FacilityFeature facilityFeature4 = new FacilityFeature(4, "Air Conditioning");
        facilityFeatureRepository.save(facilityFeature1);
        facilityFeatureRepository.save(facilityFeature2);
        facilityFeatureRepository.save(facilityFeature3);
        facilityFeatureRepository.save(facilityFeature4);

        

    }
    
}
