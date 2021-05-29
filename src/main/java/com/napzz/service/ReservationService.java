package com.napzz.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.napzz.controller.ReservationController;
import com.napzz.entity.reservation.Reservation;
import com.napzz.entity.reservation.ReservationStatus;
import com.napzz.entity.room.Room;
import com.napzz.entity.room.RoomStatus;
import com.napzz.entity.user.Customer;
import com.napzz.repository.ReservationRepository;
import com.napzz.repository.ReservationStatusRepository;
import com.napzz.repository.RoomStatusRepository;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.hibernate.mapping.Map;

@ApplicationScoped
public class ReservationService {

    @Inject
    private ReservationRepository reservationRepository;

    @Inject
    private ReservationStatusRepository reservationStatusRepository;

    @Inject
    private RoomStatusRepository roomStatusRepository;

    public Reservation uploadEvident(Reservation uploadEvidentRequest) {
        System.out.println(uploadEvidentRequest);
        Reservation checkReservation = reservationRepository.findById(uploadEvidentRequest.getReservationId()).get();
        if (checkReservation != null) {
            // System.out.println("Founded !!!" + checkReservation.getReservationId());
            checkReservation.setCitizenIdLink(uploadEvidentRequest.getCitizenIdLink());
            checkReservation.setEvidentLink(uploadEvidentRequest.getEvidentLink());
            checkReservation.setSignatureLink(uploadEvidentRequest.getSignatureLink());
            Reservation updateReservation = reservationRepository.save(checkReservation);
            return updateReservation;
        } else {
            return checkReservation;
        }
    }

    public Response reserveRoom(JsonWebToken jwtToken, Reservation reservationRequest) {
        HashMap<String, Object> responseMessage = new HashMap();
        Integer userId = Integer.parseInt(jwtToken.getClaim("USER_ID").toString());
        Customer customer = new Customer();
        customer.setUserId(userId);
        reservationRequest.setUser(customer);
        ReservationStatus reservationStatus = new ReservationStatus();
        reservationStatus.setReservationStatusId(1);
        reservationRequest.setReservationStatus(reservationStatus);
        Reservation reserveRoomOfUser = reservationRepository.findByUserUserIdAndRoomId(userId,
                reservationRequest.getRoom().getId());
        if (reserveRoomOfUser == null) {
            Reservation insertReservation = reservationRepository.save(reservationRequest);
            return Response.ok().entity(insertReservation).build();
        }
        responseMessage.put("message", "Can not Reserve again because Already Reserve this Room");
        Response response = Response.status(Status.BAD_REQUEST).entity(responseMessage).build();
        return response;
    }

    public List<Reservation> listReserves() {
        List<Reservation> listReservation = reservationRepository.findAll();
        return listReservation;
    }

    public Optional<Reservation> findReservationById(int reservationId) {
        return reservationRepository.findById(reservationId);
    }

    public List<Reservation> findReservationByUserId(int userId) {
        List<Reservation> userReservationList = reservationRepository.findByUserUserId(userId);
        return userReservationList;
    }

    public RoomStatus createRoomStatus(RoomStatus roomStatus) {
        return roomStatusRepository.save(roomStatus);
    }

    public List<RoomStatus> listRoomStatus() {
        return roomStatusRepository.findAll();
    }

    public ReservationStatus createReservationtatus(ReservationStatus reservationStatus) {
        return reservationStatusRepository.save(reservationStatus);
    }


}
