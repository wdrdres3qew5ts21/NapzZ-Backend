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
import javax.ws.rs.core.*;

import com.napzz.dto.OAuthPrincial;
import com.napzz.entity.asset.FacilityFeature;
import com.napzz.entity.asset.LandmarkFeature;
import com.napzz.entity.room.Room;
import com.napzz.service.RoomService;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class RoomController {

    @Inject
    RoomService roomService;


    @Path("init")
    @GET
    public Room response(){
        return roomService.init();
    }

    @Path("facility")
    @POST
    public Response createFacilityFeature(@RequestBody FacilityFeature facilityFeature){
        FacilityFeature createdFacilityFeature = roomService.createFacilityFeature(facilityFeature);
        return Response.ok(createdFacilityFeature).build();
    }

    @Path("landmark")
    @POST
    public Response createLandmarkFeature(@RequestBody LandmarkFeature landmarkFeature){
        LandmarkFeature createdFacilityFeature = roomService.createLandmarkFeature(landmarkFeature);
        return Response.ok(createdFacilityFeature).build();
    }

    @Path("room")
    @POST
    public Response createRoom(@RequestBody Room room){
        roomService.createRoom(room);
        return Response.ok(room).build();
    }

    @Path("room/{roomId}")
    @GET
    public Response findRoomById(@PathParam("roomId") int roomId){
        Optional<Room> room = roomService.findRoomById(roomId);
        return Response.ok(room).build();
    }

    @Path("rooms")
    @GET
    public Response listRoom(){
        List<Room> roomList = roomService.listRoom();
        return Response.ok(roomList).build();
    }
 
    
}
