package com.napzz.entity.asset;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.napzz.entity.room.Room;

@Entity
public class FacilityFeature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("facilityId")
    private int facilityId;

    private String facility;

    @OneToMany
    private List<Room> roomList;
    

    public FacilityFeature() {
        
    }

    public FacilityFeature(int facilityId, String facility) {
        this.facilityId = facilityId;
        this.facility = facility;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    @Override
    public String toString() {
        return "FacilityFeature [facility=" + facility + ", facilityId=" + facilityId + "]";
    }

}
