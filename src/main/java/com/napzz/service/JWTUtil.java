package com.napzz.service;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;

import com.napzz.entity.asset.LandmarkFeature;
import com.napzz.entity.user.User;

import org.eclipse.microprofile.jwt.Claims;
import org.springframework.data.jpa.repository.JpaRepository;

import io.smallrye.jwt.build.Jwt;

public class JWTUtil {

    public static String generateJWTToken(User user) {
        String token = Jwt.issuer("http://localhost:8080/issuer").upn(user.getEmail()).expiresIn(Duration.ofMinutes(60))
                .groups(new HashSet<>(Arrays.asList("USER", user.getUsertype())))
                .claim("USER_ID", user.getUserId())
                .claim("FIRSTNAME", user.getFirstname()).claim("LASTNAME", user.getLastname())
                .claim("ROLE", user.getUsertype()).sign();
        System.out.println(token);
        return token;
    }

}
