package com.napzz.service;

import java.net.http.HttpResponse;

import javax.enterprise.context.ApplicationScoped;

import com.fasterxml.jackson.databind.JsonNode;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class MailService {


    
    // public static JsonNode sendSimpleMessage() throws UnirestException {
	// 	HttpResponse<JsonNode> request = RestClient.post("https://api.mailgun.net/v3/" + YOUR_DOMAIN_NAME + "/messages"),
	// 		.basicAuth("api", API_KEY)
	// 		.queryString("from", "Excited User <USER@YOURDOMAIN.COM>")
	// 		.queryString("to", "artemis@example.com")
	// 		.queryString("subject", "hello")
	// 		.queryString("text", "testing")
	// 		.asJson();
	// 	return request.getBody();
	// }
    
}
