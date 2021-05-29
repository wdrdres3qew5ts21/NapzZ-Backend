package com.napzz.service;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.napzz.controller.ReservationController;
import com.napzz.entity.reservation.Reservation;
import com.napzz.repository.ReservationRepository;

@ApplicationScoped
public class ReservationService {

    @Inject
    private ReservationRepository reservationRepository;

    public Reservation uploadEvident(Reservation uploadEvidentRequest) {
        System.out.println(uploadEvidentRequest);
        Reservation checkReservation = reservationRepository.findById(uploadEvidentRequest.getReservationId()).get();
        if(checkReservation != null){
            // System.out.println("Founded !!!" + checkReservation.getReservationId());
            checkReservation.setCitizenIdLink(uploadEvidentRequest.getCitizenIdLink());
            checkReservation.setEvidentLink(uploadEvidentRequest.getEvidentLink());
            checkReservation.setSignatureLink(uploadEvidentRequest.getSignatureLink());
            Reservation updateReservation = reservationRepository.save(checkReservation);
            return updateReservation;
        }
        else{
            return checkReservation;
        }
    }

    public Reservation reserveRoom(Reservation reservationRequest) {
        Reservation insertReservation = reservationRepository.save(reservationRequest); 
        return insertReservation;
    }

    public List<Reservation> listReserves() {
        List<Reservation> listReservation = reservationRepository.findAll();
        return listReservation;
    }

    public Optional<Reservation> findReservationById(int reservationId) {
        return reservationRepository.findById(reservationId);
    }
    
}
