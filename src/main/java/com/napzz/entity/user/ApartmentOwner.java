package com.napzz.entity.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "apartmentOwnerId")
public class ApartmentOwner extends User{

    @Override
    public void setUsertype(String usertype){
        this.setUsertype("APARTMENT_OWNER");
    }

    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private int apartmentOwnerId;

    private String apartmentOwnerVerifyStatus;

    // public String getApartmentOwnerVerifyStatus() {
    //     return apartmentOwnerVerifyStatus;
    // }

    // public void setApartmentOwnerVerifyStatus(String apartmentOwnerVerifyStatus) {
    //     this.apartmentOwnerVerifyStatus = apartmentOwnerVerifyStatus;
    // }

    // @Override
    // public String toString() {
    //     return "ApartmentOwner [apartmentOwnerVerifyStatus=" + apartmentOwnerVerifyStatus + "]";
    // }

}
