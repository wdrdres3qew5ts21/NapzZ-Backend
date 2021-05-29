package com.napzz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;

import com.napzz.entity.reservation.Reservation;
import com.napzz.service.ReservationService;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;


@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class ReservationController{

    @Inject
    ReservationService reservationService;

    @Path("upload-evident")
    @POST
    public Response uploadEvident(@RequestBody Reservation uploadEvidentRequest) {
        Reservation uploadEvidentResponse = this.reservationService.uploadEvident(uploadEvidentRequest);

        if (uploadEvidentResponse != null) {
            return Response.ok(uploadEvidentResponse).build();
        }
        else{
            HashMap<String, String> response = new HashMap();
            response.put("errorMessage", "data not found");
            return Response.ok("data not found").build();            
        }

    }

    @Path("reserve-room")
    @POST
    public Response reserveRoom(@RequestBody Reservation reservationRequest) {
        Reservation reserveRoom = reservationService.reserveRoom(reservationRequest);
        return Response.ok(reserveRoom).build();
    }

    @Path("reserves")
    @GET
    public Response listReserves() {
        List<Reservation> listReserves = reservationService.listReserves();
        return Response.ok(listReserves).build();
    }

    @Path("reserve/{reservationId}")
    @GET
    public Response findReservationById(@PathParam("reservationId") int reservationId){
        Optional<Reservation> reservation = reservationService.findReservationById(reservationId);
        return Response.ok(reservation).build();
    }
}