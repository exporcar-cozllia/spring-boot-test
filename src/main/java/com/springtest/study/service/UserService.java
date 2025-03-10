package com.springtest.study.service;


import com.springtest.study.dto.LoginRequest;
import com.springtest.study.dto.UserRequest;
import com.springtest.study.dto.UserResponse;
import com.springtest.study.entry.UserEntry;
import org.springframework.http.ResponseEntity;

public interface UserService {
    public String register(UserRequest request);
//    public ResponseEntity<UserResponse> login(LoginRequest loginRequest);

    public UserEntry login(LoginRequest request);
}
