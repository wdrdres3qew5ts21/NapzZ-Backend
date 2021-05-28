package com.napzz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.resource.spi.ConfigProperty;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
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
import com.napzz.service.JWTUtil;
import com.napzz.service.RoomService;
import com.napzz.service.UserService;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class UserController {

    @Inject
    UserService userService;

    @Inject
    JsonWebToken jwt;

    @GET()
    @Path("permit-all")
    @PermitAll
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@Context SecurityContext ctx) {
        return getResponseString(ctx);
    }

    @GET
    @Path("roles-allowed")
    @RolesAllowed({ "USER" })
    @Produces(MediaType.TEXT_PLAIN)
    public String helloRolesAllowed(@Context SecurityContext ctx) {
        return getResponseString(ctx);
    }

    private String getResponseString(SecurityContext ctx) {
        String name;
        if (ctx.getUserPrincipal() == null) {
            name = "anonymous";
        } else if (!ctx.getUserPrincipal().getName().equals(jwt.getName())) {
            throw new InternalServerErrorException("Principal and JsonWebToken names do not match");
        } else {
            name = ctx.getUserPrincipal().getName();
        }
        return String.format("hello + %s," + " isHttps: %s," + " authScheme: %s," + " hasJWT: %s", name, ctx.isSecure(),
                ctx.getAuthenticationScheme(), hasJwt());
    }

    private boolean hasJwt() {
        return jwt.getClaimNames() != null;
    }

    @GET
    @Path("mail")
    public JsonNode sentMail() {
        return this.userService.sentMail();
    }

    @POST
    @Path("user/login")
    public Response login(@RequestBody User LoginRequest) {
        User loginResponse = this.userService.login(LoginRequest);
        HashMap<String, String> response = new HashMap();
        if (loginResponse == null) {
            response.put("errorMessage", "AythenticationFailed");
            return Response.status(401).entity(response).build();
        }
        String generateJWTToken = JWTUtil.generateJWTToken(loginResponse);
        response.put("jwtToken", generateJWTToken);
        return Response.ok(response).build();

    }

    @POST
    @Path("register/customer/email")
    public Customer customerRegisterWithEmail(@RequestBody Customer customerRegisterRequest) {
        return this.userService.customerRegisterWithEmail(customerRegisterRequest);
    }

    @POST
    @Path("register/aprtment-owner/email")
    public JsonNode aprtmentOwnerRegister(@RequestBody ApartmentOwner aprtmentOwnerRegisterRequest) {
        return this.userService.aprtmentOwnerRegister(aprtmentOwnerRegisterRequest);
    }

}
