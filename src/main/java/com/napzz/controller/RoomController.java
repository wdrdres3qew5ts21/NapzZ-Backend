package com.napzz.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;

import com.napzz.dto.OAuthPrincial;

@Path("/room")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RoomController {

    @GET
    @Path("/history/login")
    public OAuthPrincial oauthIsOntheCloudNative() {
        this.oAuthPrincial = oauthLogin();
        return this.oAuthPrincial;
    }
    
}
