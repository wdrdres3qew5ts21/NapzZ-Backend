package com.napzz.repository;

import com.napzz.entity.reservation.Reservation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository <Reservation,Integer> {
    
}
