package com.napzz.repository;

import java.util.List;
import java.util.Optional;

import com.napzz.entity.reservation.Reservation;
import com.napzz.entity.room.Room;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository <Reservation,Integer> {

    List<Reservation> findByUserUserId(int userId);

    Reservation findByUserUserIdAndRoomId(Integer userId, int id);

    
}
