package com.napzz.service;

import java.net.http.HttpResponse;
import java.util.Base64;

import javax.enterprise.context.ApplicationScoped;

import com.fasterxml.jackson.databind.JsonNode;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class MailService {

	@RestClient
	private MailGunEndpointInterface mailGunEndpointInterface;

	@ConfigProperty(name = "mailgun.key")
	private String MAILGUN_KEY;

	@ConfigProperty(name = "mailgun.sender")
	private String MAILGUN_SENDER;

	public String lookupAuth() {
		String authenString = "api:" + MAILGUN_KEY;
		String encodedString = Base64.getEncoder().encodeToString(authenString.getBytes());
		return "Basic " + encodedString;
	}

	public JsonNode sendMail(String recipient) {
		String subject = "Napzz Authentication";
		String text = "Confirm Reservation Room Key was: 551462";
		JsonNode httpPostMailMessage = null;
		httpPostMailMessage = mailGunEndpointInterface.httpPostMailMessage(lookupAuth(), MAILGUN_SENDER, recipient, subject, text);
		System.out.println(httpPostMailMessage);
		return httpPostMailMessage;
	}

}
