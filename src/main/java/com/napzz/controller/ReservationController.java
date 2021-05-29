package com.napzz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

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
import com.napzz.service.ReservationService;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import io.smallrye.jwt.auth.principal.JWTParser;
import io.smallrye.jwt.auth.principal.ParseException;


@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class ReservationController{

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
        try {
            jwtParser.parse(jwt.getRawToken());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Reservation reserveRoom = reservationService.reserveRoom(jwt,reservationRequest);
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