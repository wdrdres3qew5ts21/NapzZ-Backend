package com.napzz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CouponDto {


    public CouponDto(){
        
    }

    public CouponDto(String chassisNo, String couponNo, String periodicCheck, String serviceDate,
        String carDeliveryDate, String customerName, String receiptNo, String receiptDate, String receiptPeriod) {
        this.chassisNo = chassisNo;
        this.couponNo = couponNo;
        this.periodicCheck = periodicCheck;
        this.serviceDate = serviceDate;
        this.carDeliveryDate = carDeliveryDate;
        this.customerName = customerName;
        this.receiptNo = receiptNo;
        this.receiptDate = receiptDate;
        this.receiptPeriod = receiptPeriod;
    }

    @JsonProperty("Chassis_no")
    private String chassisNo;

    @JsonProperty("Coupon_no")
    private String couponNo;

    @JsonProperty("Periodic_check")
    private String periodicCheck;

    @JsonProperty("Service_date")
    private String serviceDate;

    @JsonProperty("car_delivery_date")
    private String carDeliveryDate;

    @JsonProperty("Customer_name")
    private String customerName;

    @JsonProperty("Receipt_no")
    private String receiptNo;

    @JsonProperty("Receipt_date")
    private String receiptDate;

    @JsonProperty("Receipt_period")
    private String receiptPeriod;

    public String getChassisNo() {
        return chassisNo;
    }

    public void setChassisNo(String chassisNo) {
        this.chassisNo = chassisNo;
    }

    public String getCouponNo() {
        return couponNo;
    }

    public void setCouponNo(String couponNo) {
        this.couponNo = couponNo;
    }

    public String getPeriodicCheck() {
        return periodicCheck;
    }

    public void setPeriodicCheck(String periodicCheck) {
        this.periodicCheck = periodicCheck;
    }

    public String getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(String serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getCarDeliveryDate() {
        return carDeliveryDate;
    }

    public void setCarDeliveryDate(String carDeliveryDate) {
        this.carDeliveryDate = carDeliveryDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
    }

    public String getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getReceiptPeriod() {
        return receiptPeriod;
    }

    public void setReceiptPeriod(String receiptPeriod) {
        this.receiptPeriod = receiptPeriod;
    }

    @Override
    public String toString() {
        return "CouponDto [carDeliveryDate=" + carDeliveryDate + ", chassisNo=" + chassisNo + ", couponNo=" + couponNo
                + ", customerName=" + customerName + ", periodicCheck=" + periodicCheck + ", receiptDate=" + receiptDate
                + ", receiptNo=" + receiptNo + ", receiptPeriod=" + receiptPeriod + ", serviceDate=" + serviceDate
                + "]";
    }

 

}
