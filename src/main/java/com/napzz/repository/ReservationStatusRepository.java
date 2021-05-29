package com.napzz.repository;

import com.napzz.entity.reservation.ReservationStatus;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationStatusRepository extends JpaRepository<ReservationStatus, Integer>{

}
