package com.napzz.entity.room;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RoomStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomStatusId;

    @Column(nullable = false, unique = true)
    private String roomStatus;

    public int getRoomStatusId() {
        return roomStatusId;
    }

    public void setRoomStatusId(int roomStatusId) {
        this.roomStatusId = roomStatusId;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    @Override
    public String toString() {
        return "RoomStatus [roomStatus=" + roomStatus + ", roomStatusId=" + roomStatusId + "]";
    }

}
