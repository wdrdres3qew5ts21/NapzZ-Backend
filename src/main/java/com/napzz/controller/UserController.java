package com.napzz.controller;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.resource.spi.ConfigProperty;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.napzz.dto.OAuthPrincial;
import com.napzz.dto.authen.LoginRequest;
import com.napzz.entity.asset.FacilityFeature;
import com.napzz.entity.asset.LandmarkFeature;
import com.napzz.entity.room.Room;
import com.napzz.entity.user.ApartmentOwner;
import com.napzz.entity.user.Customer;
import com.napzz.entity.user.User;
import com.napzz.service.RoomService;
import com.napzz.service.UserService;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;


@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class UserController {

    @Inject
    UserService userService;

    @GET
    @Path("mail")
    public JsonNode sentMail(){
        return this.userService.sentMail();
    }

    @POST
    @Path("user/login")
    public User login(@RequestBody User LoginRequest){
        return this.userService.login(LoginRequest);
    }

    @POST
    @Path("register/customer/email")
    public Customer customerRegisterWithEmail(@RequestBody Customer customerRegisterRequest){
        return this.userService.customerRegisterWithEmail(customerRegisterRequest);
    }

    @POST
    @Path("register/aprtment-owner/email")
    public JsonNode aprtmentOwnerRegister(@RequestBody ApartmentOwner aprtmentOwnerRegisterRequest){
        return this.userService.aprtmentOwnerRegister(aprtmentOwnerRegisterRequest);
    }
  
    
}
