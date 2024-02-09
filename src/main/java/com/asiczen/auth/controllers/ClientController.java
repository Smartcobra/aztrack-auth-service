package com.asiczen.auth.controllers;

import com.asiczen.auth.dtos.ApiResponse;
import com.asiczen.auth.dtos.ClientRegistrationRequestDto;
import com.asiczen.auth.dtos.ClientRegistrationResponseDto;
import com.asiczen.auth.services.ClientRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class ClientController {


    private final ClientRegistrationService clientRegistrationService;

    @Autowired
    public ClientController(ClientRegistrationService clientRegistrationService) {
        this.clientRegistrationService = clientRegistrationService;
    }


    @PostMapping("/register")
    public ResponseEntity<ApiResponse<ClientRegistrationResponseDto>> registerClient(@RequestBody ClientRegistrationRequestDto requestDto){

       return  clientRegistrationService.registerClient(requestDto)
                .map(response-> ResponseEntity.ok(new ApiResponse<>("Success",response )))
                .orElseGet(()->ResponseEntity.status(400).body(new ApiResponse<>("Success",null )));

    }
}
