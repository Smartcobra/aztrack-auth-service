package com.asiczen.auth.services;

import com.asiczen.auth.dtos.LoginRequestDto;
import com.asiczen.auth.dtos.LogoutRequestDto;
import com.asiczen.auth.dtos.SignUpRequestDto;
import com.asiczen.auth.dtos.UserDto;
import com.asiczen.auth.entites.Token;
import com.asiczen.auth.entites.User;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserService {
     Token login(String email, String password);

     User signUp(SignUpRequestDto signUpRequestDto);
    void logout(String token);

     User validateToken(String token);
}
