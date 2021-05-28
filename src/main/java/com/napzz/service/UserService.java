package com.napzz.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.fasterxml.jackson.databind.JsonNode;

@ApplicationScoped
public class UserService {

    @Inject
    private MailService mailService;

    public JsonNode sentMail() {
        return mailService.sendMail();
    }

    

}
