package com.napzz.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.fasterxml.jackson.databind.JsonNode;
import com.napzz.dto.authen.LoginRequest;
import com.napzz.entity.user.ApartmentOwner;
import com.napzz.entity.user.Customer;
import com.napzz.entity.user.User;
import com.napzz.repository.ApartmentOwnerRepository;
import com.napzz.repository.CustomerRepository;
import com.napzz.repository.UserRepository;

@ApplicationScoped
public class UserService {

    @Inject
    private MailService mailService;

    @Inject
    private UserRepository userRepository;

    @Inject 
    private CustomerRepository customerRepository;

    @Inject 
    private ApartmentOwnerRepository apartmentOwnerRepository;

    public JsonNode sentMail() {
        return mailService.sendMail();
    }

    public JsonNode login(User loginRequest) {
        return null;
    }

    public JsonNode registerWithEmail(User registerRequest) {
        return null;
    }

    public Customer customerRegisterWithEmail(Customer customerRegisterRequest) {
        Customer savedCustomer = customerRepository.save(customerRegisterRequest);
        return savedCustomer;
    }

    public JsonNode aprtmentOwnerRegister(ApartmentOwner aprtmentOwnerRegisterRequest) {
        return null;
    }

    

}
