package com.example.microservices.mapper;

import com.example.microservices.dto.UserRequestDto;
import com.example.microservices.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserRequestDtoMapper {

    public User mapToUserEntity(UserRequestDto userRequestDto) {
        return new User(
                userRequestDto.getFirstName(),
                userRequestDto.getLastName(),
                userRequestDto.getDob(),
                userRequestDto.getAddress(),
                userRequestDto.getEmail()
        );
    }

}
