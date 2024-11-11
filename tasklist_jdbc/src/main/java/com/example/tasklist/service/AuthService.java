package com.example.tasklist.service;

import com.example.tasklist.web.auth.JwtRequest;
import com.example.tasklist.web.auth.JwtResponse;

public interface AuthService {

    JwtResponse login(JwtRequest loginRequest);

    JwtResponse refresh(String refreshToken);


}
