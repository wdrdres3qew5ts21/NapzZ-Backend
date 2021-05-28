package com.napzz.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.napzz.entity.asset.Image;
import com.napzz.entity.location.Location;

import org.hibernate.annotations.GeneratorType;

@Entity
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aprtmentId;

    private String apartmentName;

    @Column(length = 5000)
    private String apartmentDescription;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Image> images;

    @Embedded
    private Location location;

    public int getAprtmentId() {
        return aprtmentId;
    }

    public void setAprtmentId(int aprtmentId) {
        this.aprtmentId = aprtmentId;
    }

    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }

    public String getApartmentDescription() {
        return apartmentDescription;
    }

    public void setApartmentDescription(String apartmentDescription) {
        this.apartmentDescription = apartmentDescription;
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
        return "Apartment [apartmentDescription=" + apartmentDescription + ", apartmentName=" + apartmentName
                + ", aprtmentId=" + aprtmentId + ", images=" + images + ", location=" + location + "]";
    }

}
