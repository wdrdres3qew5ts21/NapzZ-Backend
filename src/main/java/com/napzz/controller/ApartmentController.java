package com.napzz.controller;

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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.*;

import com.napzz.dto.OAuthPrincial;
import com.napzz.entity.Apartment;
import com.napzz.entity.asset.FacilityFeature;
import com.napzz.entity.asset.LandmarkFeature;
import com.napzz.entity.room.Room;
import com.napzz.service.ApartmentService;
import com.napzz.service.RoomService;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class ApartmentController {

    @Inject
    ApartmentService apartmentService;

    @Path("apartment/{apartmentId}")
    @GET
    public Response findByAprtmentId(@PathParam("apartmentId") int apartmentId) {
        Optional<Apartment> room = apartmentService.findByAprtmentId(apartmentId);
        return Response.ok(room).build();
    }

    @Path("apartments")
    @GET
    public Response listApartment(
        @QueryParam("name") String apartmentName, 
        @QueryParam("province") String province
    ){
        List<Apartment> aprtmentList = apartmentService.listApartment(apartmentName,province);
        return Response.ok(aprtmentList).build();
    }

    @Path("apartment")
    @POST
    public Response createApartment(@RequestBody Apartment apartment) {
        Apartment createApartment = apartmentService.createApartment(apartment);
        return Response.ok(createApartment).build();
    }

}
