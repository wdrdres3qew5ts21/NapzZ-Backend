package com.napzz.controller;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.util.Base64;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.napzz.dto.CouponDto;
import com.napzz.dto.OAuthPrincial;
import com.napzz.dto.RecallDto;
import com.napzz.service.AuthenicationInterface;
import com.napzz.service.CountryInterface;
import com.napzz.service.ENissanInterface;

@Path("/integration")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class IntegrationController {

    @Inject
    @RestClient
    private AuthenicationInterface authenicationInterface;

    @Inject
    @RestClient
    private ENissanInterface enissanInterface;

    @Inject
    @RestClient
    private CountryInterface countryInterface;

    @ConfigProperty(name = "enissan.clientid")
    private String ENISSAN_INTERFACE_CLIENT_ID;

    @ConfigProperty(name = "enissan.clientsecret")
    private String ENISSAN_INTERFACE_CLIENT_SECRET;

    private String grantType = "client_credentials";

    private String scope = "api";

    private OAuthPrincial oAuthPrincial;

    private String bearerToken;

    public IntegrationController() {
        System.out.println(ENISSAN_INTERFACE_CLIENT_ID);
        System.out.println(ENISSAN_INTERFACE_CLIENT_SECRET);
    }

    private OAuthPrincial oauthLogin() {
        String appendCrendentials = ENISSAN_INTERFACE_CLIENT_ID + ":" + ENISSAN_INTERFACE_CLIENT_SECRET;
        String encodedBase64Credentials = Base64.getEncoder().encodeToString(appendCrendentials.getBytes());
        String basicAuthenFormatted = "Basic " + encodedBase64Credentials;
        this.oAuthPrincial = authenicationInterface.authenticationOAuth(basicAuthenFormatted, grantType, scope);
        this.bearerToken = "Bearer " + this.oAuthPrincial.getAccessToken();
        return this.oAuthPrincial;
    }

    @GET
    @Path("/history/login")
    public OAuthPrincial oauthIsOntheCloudNative() {
        this.oAuthPrincial = oauthLogin();
        return this.oAuthPrincial;
    }

    @GET
    @Path("/history/recall")
    public List<RecallDto> getRecallChassisNo(@QueryParam("chassisNo") String chassisNo) {
        oauthLogin();
        List<RecallDto> recallList = enissanInterface.getRecallChassisNo(this.bearerToken, chassisNo);
        return recallList;
    }

    @GET
    @Path("/history/coupon")
    public List<CouponDto> getCouponByChassisNo(@QueryParam("chassisNo") String chassisNo) {
        oauthLogin();
        List<CouponDto> couponList = enissanInterface.getCouponByChassisNo(this.bearerToken, chassisNo);
        return couponList;
    }

    // @GET
    // @Path("/history/country")
    // public List<CountryDto> getCountry(@QueryParam("chassisNo") String chassisNo) {
    //     oauthLogin();
    //     List<CountryDto> CountryDto = countryInterface.getByName("France");
    //     return CountryDto;
    // }

}
