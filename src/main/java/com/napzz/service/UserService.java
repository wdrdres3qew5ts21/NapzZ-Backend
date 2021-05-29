package com.napzz.service;

import java.util.HashMap;
import java.util.Random;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.fasterxml.jackson.databind.JsonNode;
import com.napzz.dto.authen.EmailLoginResponse;
import com.napzz.entity.user.ApartmentOwner;
import com.napzz.entity.user.Customer;
import com.napzz.entity.user.User;
import com.napzz.repository.ApartmentOwnerRepository;
import com.napzz.repository.CustomerRepository;
import com.napzz.repository.UserRepository;

import org.apache.commons.lang3.RandomStringUtils;

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

    public JsonNode sentMailTwoFactorAuthentication(String recipient, String emailToken) {
        return mailService.sentMailTwoFactorAuthentication(recipient, emailToken);
    }

    public User login(User loginRequest) {
        User foundedUsername = userRepository.findByUsername(loginRequest.getUsername());
        if (foundedUsername != null) {
            if (foundedUsername.getPassword().equals(loginRequest.getPassword())) {
                // เจอ user แล้วต้องส่ง Email ไปหาผู้ใช้คนนั้น
                // 1. Generate Token สั้นๆก่อน
                String randomAlphanumeric = RandomStringUtils.randomAlphanumeric(6);
                foundedUsername.setEmailToken(randomAlphanumeric);
                // 2. บันทึก Token นั้นลง Table SecurityAuthentication ใน Field Security
                User emailLoginResponse = userRepository.save(foundedUsername);
                // 3. ส่งเมล์ที่มีข้อมูลเกี่ยวกับ Fields นั้นออกไปหา User ที่ Login ผ่าน HashMap
                this.sentMailTwoFactorAuthentication(emailLoginResponse.getEmail(), emailLoginResponse.getEmailToken());
                return emailLoginResponse;
            }
        }
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

    public HashMap verifyEmailToken(User emailVerifyRequest) {
        HashMap<String, String> response = new HashMap();
        User foundedUsername = userRepository.findByUsername(emailVerifyRequest.getUsername());
        if (foundedUsername.getPassword().equals(emailVerifyRequest.getPassword())) {
            if (emailVerifyRequest.getEmailToken().equals(foundedUsername.getEmailToken())) {
                String generateJWTToken = JWTUtil.generateJWTToken(foundedUsername);
                response.put("jwtToken", generateJWTToken);
                response.put("message", "Authentication with 2 Factor Email Success");
                foundedUsername.setEmailToken(null);
                userRepository.save(foundedUsername);
                return response;
            }
        }
        return null;
    }

}
