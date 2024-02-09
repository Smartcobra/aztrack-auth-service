package com.asiczen.auth.services;

import com.asiczen.auth.dtos.CredentialsDto;
import com.asiczen.auth.dtos.SignUpDto;
import com.asiczen.auth.dtos.UserDto;

public interface UserService {
    UserDto login(CredentialsDto credentialsDto);

    UserDto register(SignUpDto userDto);

    UserDto findByLogin(String login);
}
