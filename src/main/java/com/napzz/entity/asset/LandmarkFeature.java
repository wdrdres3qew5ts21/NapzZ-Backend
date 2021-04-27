package com.napzz.entity.asset;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class LandmarkFeature {

    @Id
    @JsonProperty("landmarkId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int landmarkId;

    private String landmark;


    public LandmarkFeature() {
        
    }

    public LandmarkFeature(int landmarkId, String landmark) {
        this.landmarkId = landmarkId;
        this.landmark = landmark;
    }

    public int getLandmarkId() {
        return landmarkId;
    }

    public void setLandmarkId(int landmarkId) {
        this.landmarkId = landmarkId;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    @Override
    public String toString() {
        return "LandmarkFeature [landmark=" + landmark + ", landmarkId=" + landmarkId + "]";
    }

}
