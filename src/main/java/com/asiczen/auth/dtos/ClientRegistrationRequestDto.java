package com.asiczen.auth.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientRegistrationRequestDto {
    private String clientId;
    private String password;
    private String authenticationType;
    private Set<String> grantTypes;
    private String redirectUri;
    private  Set<String> scopes;
}
