package com.napzz.entity.asset;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class FacilityFeature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("facilityId")
    private int facilityId;

    private String facility;

    public FacilityFeature() {
        
    }

    public FacilityFeature(int facilityId, String facility) {
        this.facilityId = facilityId;
        this.facility = facility;
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
