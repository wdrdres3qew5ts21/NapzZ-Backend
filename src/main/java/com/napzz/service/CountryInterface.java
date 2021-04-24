package com.napzz.service;

import java.util.List;
import java.util.Set;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import com.napzz.dto.CountryDto;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


@Path("/v2")
@RegisterRestClient(configKey = "country")
public interface CountryInterface {
    
    @GET
    @Path("/name/{name}")
    List<CountryDto> getByName(@PathParam("name") String name);
    
}
