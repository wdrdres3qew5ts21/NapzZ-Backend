package com.napzz.entity.reservation;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.napzz.entity.room.Room;
import com.napzz.entity.user.User;

@Entity
public class ReservationStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationStatusId;

    @Column(nullable = false, unique = true)
    private String reservationStatus;

    public int getReservationStatusId() {
        return reservationStatusId;
    }

    public void setReservationStatusId(int reservationStatusId) {
        this.reservationStatusId = reservationStatusId;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    @Override
    public String toString() {
        return "ReservationStatus [reservationStatus=" + reservationStatus + ", reservationStatusId="
                + reservationStatusId + "]";
    }

}
