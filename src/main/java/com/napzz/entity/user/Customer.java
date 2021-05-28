package com.napzz.entity.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "customerId")
public class Customer extends User{


    public Customer(){
        this.setUsertype("CUSTOMER");
    }

    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private String customerId;

    // public String getCustomerId() {
    //     return customerId;
    // }

    // public void setCustomerId(String customerId) {
    //     this.customerId = customerId;
    // }

    // @Override
    // public String toString() {
    //     return "Customer [customerId=" + customerId + "]";
    // }

}
