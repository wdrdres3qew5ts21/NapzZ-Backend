package com.napzz.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.napzz.controller.ReservationController;
import com.napzz.entity.reservation.Reservation;
import com.napzz.repository.ReservationRepository;

@ApplicationScoped
public class ReservationService {

    @Inject
    private ReservationRepository reservationRepository;

    // public static void main(String[] args) {
    //     String checkReservation = Reservation.findById(0);
    //     if(checkReservation != null){
    //         System.out.println(checkReservation);
    //     }
    //     else{
    //         System.out.println(checkReservation);
    //     }
    // }

    public void uploadEvident(Reservation uploadEvidentRequest) {
        String checkReservation = Reservation.findById(uploadEvidentRequest.getReservationId());
        if(checkReservation != null){
            // Reservation.save();
        }
        else{
            return ;
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
    
}
