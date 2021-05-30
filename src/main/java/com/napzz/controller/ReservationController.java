package com.napzz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;

import com.napzz.entity.reservation.Reservation;
import com.napzz.entity.reservation.ReservationStatus;
import com.napzz.entity.room.RoomStatus;
import com.napzz.service.ReservationService;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import io.smallrye.jwt.auth.principal.JWTParser;
import io.smallrye.jwt.auth.principal.ParseException;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class ReservationController {

    @Inject
    ReservationService reservationService;

    @Inject
    JsonWebToken jwt;

    @Inject
    JWTParser jwtParser;

    @Path("upload-evident")
    @POST
    public Response uploadEvident(@RequestBody Reservation uploadEvidentRequest) {
        Reservation uploadEvidentResponse = this.reservationService.uploadEvident(uploadEvidentRequest);
        if (uploadEvidentResponse != null) {
            return Response.ok(uploadEvidentResponse).build();
        } else {
            HashMap<String, String> response = new HashMap();
            response.put("errorMessage", "data not found");
            return Response.ok("data not found").build();
        }
    }

    @Path("reserve-room")
    @RolesAllowed({ "USER" })
    @POST
    public Response reserveRoom(@RequestBody Reservation reservationRequest) {
        try {
            jwtParser.parse(jwt.getRawToken());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return reservationService.reserveRoom(jwt, reservationRequest);
    }

    @Path("reserves")
    @GET
    public Response listReserves() {
        List<Reservation> listReserves = reservationService.listReserves();
        return Response.ok(listReserves).build();
    }

    @Path("reserve/{reservationId}")
    @GET
    public Response findReservationById(@PathParam("reservationId") int reservationId) {
        Optional<Reservation> reservation = reservationService.findReservationById(reservationId);
        return Response.ok(reservation).build();
    }

    @Path("reserve/user")
    @RolesAllowed({ "USER" })
    @GET
    public Response findReservationByUserId() {
        try {
            jwtParser.parse(jwt.getRawToken());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Integer userId = Integer.parseInt(jwt.getClaim("USER_ID").toString());
        List<Reservation> userResrvationList = reservationService.findReservationByUserId(userId);
        return Response.ok(userResrvationList).build();
    }

    @POST
    @Path("room-status")
    public Response createRoomStatus(@RequestBody RoomStatus roomStatus ) {
        RoomStatus createdRoomStatus = reservationService.createRoomStatus(roomStatus);
        return Response.ok(createdRoomStatus).build();
    }

    @GET
    @Path("room-status")
    public Response listRoomStatus() {
        List<RoomStatus> listRoomStatus = reservationService.listRoomStatus();
        return Response.ok(listRoomStatus).build();
    }

    @POST
    @Path("reservation-status")
    public Response createReservationtatus(@RequestBody ReservationStatus reservationStatus ) {
        ReservationStatus createdReservationStatus = reservationService.createReservationtatus(reservationStatus);
        return Response.ok(createdReservationStatus).build();
    }

    @GET
    @Path("reservation-status")
    public Response listReservationtatus() {
        List<RoomStatus> listRoomStatus = reservationService.listRoomStatus();
        return Response.ok(listRoomStatus).build();
    }


}