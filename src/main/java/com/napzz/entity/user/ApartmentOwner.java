package com.napzz.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "apartmentOwnerId")
public class ApartmentOwner extends User{

    @Column(name="apartmentOwnerId",insertable = false,updatable = false)
    private int apartmentOwnerId;

    public ApartmentOwner(){
        this.setUsertype("APARTMENT_OWNER");
    }


    public int getApartmentOwnerId() {
        return apartmentOwnerId;
    }

    public void setApartmentOwnerId(int apartmentOwnerId) {
        this.apartmentOwnerId = apartmentOwnerId;
    }

    private String apartmentOwnerVerifyStatus;

    public String getApartmentOwnerVerifyStatus() {
        return apartmentOwnerVerifyStatus;
    }

    public void setApartmentOwnerVerifyStatus(String apartmentOwnerVerifyStatus) {
        this.apartmentOwnerVerifyStatus = apartmentOwnerVerifyStatus;
    }

    @Override
    public String toString() {
        return "ApartmentOwner [apartmentOwnerVerifyStatus=" + apartmentOwnerVerifyStatus + "]";
    }

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
