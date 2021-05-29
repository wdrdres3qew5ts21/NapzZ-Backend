package com.napzz.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.napzz.entity.asset.Image;
import com.napzz.entity.location.Location;
import com.napzz.entity.room.Room;



@Entity
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int apartmentId;

    private String name;

    @Column(length = 5000)
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Image> images;

    @Embedded
    private Location location;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "apartment")
    //@JsonIgnoreProperties("apartment")
    private List<Room> roomList;

    public int getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(int aprtmentId) {
        this.apartmentId = aprtmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Apartment [apartmentId=" + apartmentId + ", description=" + description + ", images=" + images
                + ", location=" + location + ", name=" + name + ", roomList=" + roomList + "]";
    }

}
