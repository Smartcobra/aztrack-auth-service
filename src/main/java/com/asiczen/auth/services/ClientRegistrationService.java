package com.asiczen.auth.services;


import com.asiczen.auth.dtos.ClientRegistrationRequestDto;
import com.asiczen.auth.dtos.ClientRegistrationResponseDto;

import java.util.Optional;

public interface ClientRegistrationService {
    Optional<ClientRegistrationResponseDto> registerClient (ClientRegistrationRequestDto requestDto);
}
