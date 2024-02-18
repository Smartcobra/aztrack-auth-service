package com.asiczen.auth.dtos;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class SignUpRequestDto {
    private String email;
    private String password;
    private String userName;
    private String firstName;
    private String lastName;
    private boolean deleted=false;
}