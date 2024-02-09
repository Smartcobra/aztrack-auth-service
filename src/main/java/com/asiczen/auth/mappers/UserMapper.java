package com.asiczen.auth.mappers;

import com.asiczen.auth.dtos.SignUpDto;
import com.asiczen.auth.dtos.UserDto;
import com.asiczen.auth.entites.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);
}
