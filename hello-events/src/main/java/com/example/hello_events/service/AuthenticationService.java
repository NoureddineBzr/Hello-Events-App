package com.example.hello_events.service;

import com.example.hello_events.dao.request.SignUpRequest;
import com.example.hello_events.dao.request.SigninRequest;
import com.example.hello_events.dao.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}