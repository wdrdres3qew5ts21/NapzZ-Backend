package com.napzz.entity.location;

public class Location {

    private String city;

    private String detail;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Location [city=" + city + ", detail=" + detail + "]";
    }

}
