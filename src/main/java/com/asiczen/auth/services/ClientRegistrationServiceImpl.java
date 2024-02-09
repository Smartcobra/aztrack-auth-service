package com.asiczen.auth.services;

import com.asiczen.auth.dtos.ClientRegistrationRequestDto;
import com.asiczen.auth.dtos.ClientRegistrationResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Slf4j
public class ClientRegistrationServiceImpl implements ClientRegistrationService {
    @Override
    public Optional<ClientRegistrationResponseDto> registerClient(ClientRegistrationRequestDto requestDto) {
        return Optional.of(new ClientRegistrationResponseDto("56565656565656"));
    }
}
