package com.napzz.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.Form;

import com.napzz.dto.OAuthPrincial;


@RegisterRestClient(configKey = "authentication-interface")
public interface AuthenicationInterface {

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/debug-oauth-provider/oauth2/token")
	public OAuthPrincial authenticationOAuth(@HeaderParam("Authorization") String basicAuthenCredential,
    @FormParam("grant_type") String grantType,
    @FormParam("scope") String scope  );
    
}
