package com.napzz.entity.reservation;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.napzz.entity.room.Room;
import com.napzz.entity.user.User;

@Entity
public class Reservation {

    @OneToOne
    private Room room;

    @Id
    @JsonProperty("reservationId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationId;

    @OneToOne()
    private User user;

    private String citizenIdLink;

    private String evidentLink;

    private String signatureLink;

    public Reservation() {
        
    }

    public Reservation(int reservationId, String citizenIdLink, String evidentLink, String signatureLink) {
        this.reservationId = reservationId;
        this.citizenIdLink = citizenIdLink;
        this.evidentLink = evidentLink;
        this.signatureLink = signatureLink;
    }

    

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public String getCitizenIdLink() {
        return citizenIdLink;
    }

    public void setCitizenIdLink(String citizenIdLink) {
        this.citizenIdLink = citizenIdLink;
    }

    public String getEvidentLink() {
        return evidentLink;
    }

    public void setEvidentLink(String evidentLink) {
        this.evidentLink = evidentLink;
    }

    public String getSignatureLink() {
        return signatureLink;
    }

    public void setSignatureLink(String signatureLink) {
        this.signatureLink = signatureLink;
    }

    @Override
    public String toString() {
        return "Reservation [reservationId=" + reservationId + ", citizenIdLink=" + citizenIdLink + ", evidentLink=" + evidentLink + ", signatureLink=" + signatureLink + "]";
    }

}
