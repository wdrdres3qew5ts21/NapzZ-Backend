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
import com.napzz.dto.authen.EmailLoginResponse;
import com.napzz.entity.asset.FacilityFeature;
import com.napzz.entity.asset.LandmarkFeature;
import com.napzz.entity.room.Room;
import com.napzz.entity.user.ApartmentOwner;
import com.napzz.entity.user.Customer;
import com.napzz.entity.user.User;
import com.napzz.service.JWTUtil;
import com.napzz.service.RoomService;
import com.napzz.service.UserService;
import io.smallrye.jwt.auth.principal.JWTParser;
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

    @Inject
    JWTParser jwtParser;

    @GET()
    @Path("permit-all")
    @PermitAll
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@Context SecurityContext ctx) {
        jwt.getRawToken();
        return getResponseString(ctx);
    }

    @GET()
    @Path("check-all")
    @PermitAll
    @Produces(MediaType.TEXT_PLAIN)
    public String check() {
        return jwt.getRawToken();
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

    @POST
    @Path("user/login")
    public Response login(@RequestBody User LoginRequest) {
        User loginResponse = this.userService.login(LoginRequest);
        HashMap<String, Object> response = new HashMap();
        if (loginResponse == null) {
            response.put("message", "Authentication Failed");
            return Response.status(401).entity(response).build();
        }
        // Login สำเร็จไม่เป็น null
        response.put("userId", loginResponse.getUserId());
        response.put("username", loginResponse.getUsername());
        response.put("emailToken", loginResponse.getEmailToken());
        response.put("message", "Please Check Youe Junk Email and using Email Token for verify");
        return Response.ok(response).build();
    }

    @POST
    @Path("user/login/twofactor/verify-email")
    public Response verifyEmailToken(@RequestBody User emailVerifyRequest) {
        HashMap verifyEmailTokenResponse = this.userService.verifyEmailToken(emailVerifyRequest);
        if (verifyEmailTokenResponse != null) {
            return Response.ok(verifyEmailTokenResponse).build();
        }
        verifyEmailTokenResponse = new HashMap<>();
        verifyEmailTokenResponse.put("message", "Faile Authentication with Email Please check your Email Token Again !");
        return Response.status(401).entity(verifyEmailTokenResponse).build();
    }

    @POST
    @Path("register/customer/email")
    public Customer customerRegisterWithEmail(@RequestBody Customer customerRegisterRequest) {
        return this.userService.customerRegisterWithEmail(customerRegisterRequest);
    }

    @POST
    @Path("register/aprtment-owner/email")
    public ApartmentOwner aprtmentOwnerRegister(@RequestBody ApartmentOwner aprtmentOwnerRegisterRequest) {
        return this.userService.apartmentOwnerRegister(aprtmentOwnerRegisterRequest);
    }

}
