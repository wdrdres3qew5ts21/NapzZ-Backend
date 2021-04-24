package com.napzz.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.napzz.dto.CouponDto;
import com.napzz.dto.RecallDto;

// @Path("/v2")
@RegisterRestClient(configKey = "enissan-interface")
public interface ENissanInterface {

    @GET
    @Path("/history/coupon")
    List<CouponDto> getCouponByChassisNo(@HeaderParam("Authorization") String authorization,
            @QueryParam("chassisNo") String chassisNo);

    @GET
    @Path("/history/recall")
    List<RecallDto> getRecallChassisNo(@HeaderParam("Authorization") String authorization,
            @QueryParam("chassisNo") String chassisNo);

   

}
