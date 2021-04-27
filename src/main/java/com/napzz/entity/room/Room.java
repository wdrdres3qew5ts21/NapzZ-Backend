package com.napzz.entity.room;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat.Feature;
import com.napzz.entity.asset.FacilityFeature;
import com.napzz.entity.asset.Image;
import com.napzz.entity.asset.LandmarkFeature;
import com.napzz.entity.location.Location;
import com.napzz.entity.review.Review;

import org.jboss.logmanager.handlers.SyslogHandler.Facility;

@Entity
public class Room {

    @Id
    private int id;

    private String roomName;

    @Column(length = 4000)
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Image> images;

    private double price;

    @OneToOne
    private ContractType contractType;

    @ManyToMany
    private List<LandmarkFeature> features;

    @OneToMany
    private List<FacilityFeature> facilities;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Review> reviews;

    @Embedded
    private Location location;

    public Room(){

    }

    public Room(int id, String roomName, String description, List<Image> images, double price, ContractType contractType,
            List<LandmarkFeature> features, List<FacilityFeature> facilities, List<Review> reviews, Location location) {
        this.id = id;
        this.roomName = roomName;
        this.description = description;
        this.images = images;
        this.price = price;
        this.contractType = contractType;
        this.features = features;
        this.facilities = facilities;
        this.reviews = reviews;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ContractType getContractType() {
        return contractType;
    }

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }

    public List<LandmarkFeature> getFeatures() {
        return features;
    }

    public void setFeatures(List<LandmarkFeature> features) {
        this.features = features;
    }

    public List<FacilityFeature> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<FacilityFeature> facilities) {
        this.facilities = facilities;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Room [contractType=" + contractType + ", description=" + description + ", facilities=" + facilities
                + ", features=" + features + ", id=" + id + ", images=" + images + ", location=" + location + ", price="
                + price + ", reviews=" + reviews + ", roomName=" + roomName + "]";
    }
    
}
