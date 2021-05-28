package com.napzz.service;

import java.util.Base64;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.JsonNode;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.quarkus.arc.config.ConfigProperties;

@RegisterRestClient
public interface MailGunEndpointInterface {

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("messages")
    public JsonNode httpPostMailMessage(
        @HeaderParam("Authorization") String authorization,
        @FormParam("from") String from, 
        @FormParam("to") String to, 
        @FormParam("subject") String subject,
        @FormParam("text") String text);
}