package com.springtest.study.controller;


import com.springtest.study.dto.LoginRequest;
import com.springtest.study.dto.UserRequest;
import com.springtest.study.dto.UserResponse;
import com.springtest.study.entry.UserEntry;
import com.springtest.study.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRequest request) throws Exception{
        userService.register(request);
        return ResponseEntity
                .ok()
                .build();
    }

    @GetMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody LoginRequest request) throws  Exception{
        UserEntry user = userService.login(request);

        if (user == null) {
            throw new RuntimeException("Invaild user");
        }

        UserResponse userResponse = new UserResponse(user.getId(), user.getName(), user.getPassword());
        return ResponseEntity.ok(userResponse);
    }

}
