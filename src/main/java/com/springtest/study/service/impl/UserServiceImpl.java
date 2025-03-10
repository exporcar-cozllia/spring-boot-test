package com.springtest.study.service.impl;

import com.springtest.study.dto.LoginRequest;
import com.springtest.study.dto.UserRequest;
import com.springtest.study.dto.UserResponse;
import com.springtest.study.entry.UserEntry;
import com.springtest.study.repository.UserRepository;
import com.springtest.study.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public String register(UserRequest request) {

        UserEntry user = UserEntry.builder()
                .password(request.getPassword())
                .name(request.getName())
                .build();
        userRepository.save(user);

        return "ok";
    }

//    @Override
//    public ResponseEntity<UserResponse> login(LoginRequest loginRequest) {
//        Optional<UserEntry> userOpt = userRepository.findByName(loginRequest.getName());
//
//        if (userOpt.isPresent()) {
//            UserEntry user = userOpt.get();
//            // 비밀번호 검증
//            if (loginRequest.getPassword().equals(user.getPassword())) {
//                UserResponse userResponse = new UserResponse(user.getId(), user.getName(), user.getPassword());
//
//                return ResponseEntity.ok(userResponse);
//            } else {
//                throw new RuntimeException("Invalid password");
//            }
//        } else {
//            throw new RuntimeException("User not found");
//        }
//    }


    @Override
    public UserEntry login(LoginRequest loginRequest) {
        Optional<UserEntry> userOpt = userRepository.findByName(loginRequest.getName());

        if (userOpt.isPresent()) {
            UserEntry user = userOpt.get();
            // 비밀번호 검증
            if (loginRequest.getPassword().equals(user.getPassword())) {
                return user;  // 정상적으로 UserEntry를 반환
            } else {
                throw new RuntimeException("Invalid password");
            }
        } else {
            throw new RuntimeException("User not found");
        }
    }


}
