package com.asiczen.auth.controllers;

import com.asiczen.auth.dtos.*;
import com.asiczen.auth.entites.Token;
import com.asiczen.auth.services.UserService;
import com.asiczen.auth.services.UserServiceImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public Token login(@RequestBody LoginRequestDto request) {
        // check if email and password in db
        // if yes return user
        // else throw some error
        return userService.login(request.getEmail(), request.getPassword());
    }

    @PostMapping("/signup")
    public UserDto signUp(@RequestBody SignUpRequestDto request) {
        return UserDto.from(userService.signUp(request));
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestBody LogoutRequestDto request) {
        // delete token if exists -> 200
        // if doesn't exist give a 404

        userService.logout(request.getToken());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/validate/{token}")
    public UserDto validateToken(@PathVariable("token") @NonNull String token) {
        return UserDto.from(userService.validateToken(token));
    }
}
