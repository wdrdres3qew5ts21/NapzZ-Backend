package com.napzz.controller;

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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.*;

import com.napzz.dto.OAuthPrincial;
import com.napzz.entity.Apartment;
import com.napzz.entity.asset.FacilityFeature;
import com.napzz.entity.asset.LandmarkFeature;
import com.napzz.entity.room.Room;
import com.napzz.service.ApartmentService;
import com.napzz.service.RoomService;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import io.smallrye.jwt.auth.principal.JWTParser;
import io.smallrye.jwt.auth.principal.ParseException;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class ApartmentController {

    @Inject
    ApartmentService apartmentService;

    @Inject
    JsonWebToken jwt;

    @Inject
    JWTParser jwtParser;

    @Path("apartment/{apartmentId}")
    @GET
    public Response findByAprtmentId(@PathParam("apartmentId") int apartmentId) {
        Optional<Apartment> room = apartmentService.findByAprtmentId(apartmentId);
        return Response.ok(room).build();
    }

    @Path("apartments")
    @GET
    public Response listApartment(@QueryParam("name") String apartmentName, @QueryParam("province") String province) {
        List<Apartment> aprtmentList = apartmentService.listApartment(apartmentName, province);
        return Response.ok(aprtmentList).build();
    }

    @Path("apartment/owner/{apartmentOwnerId}")
    @GET
    public Response findByApartmentOwnerUserId(@PathParam("apartmentOwnerId") int apartmentOwnerId) {
        List<Apartment> apartmentListofApartmentOwner = apartmentService.findByApartmentOwnerUserId(apartmentOwnerId);
        return Response.ok(apartmentListofApartmentOwner).build();
    }

    @Path("apartment")
    @RolesAllowed({ "APARTMENT_OWNER" })
    @POST
    public Response createApartment(@RequestBody Apartment apartment) {
        try {
            jwtParser.parse(jwt.getRawToken());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Integer apartmentOwnerId = Integer.parseInt(jwt.getClaim("USER_ID").toString());
        Apartment createdApartment = apartmentService.createApartment(apartmentOwnerId,apartment);
        return Response.ok(createdApartment).build();
    }

}
