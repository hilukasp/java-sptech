package com.example.spring_JWToken.dto;

import com.example.spring_JWToken.dto.UserRequestDto;
import com.example.spring_JWToken.dto.UserResponseDto;
import com.example.spring_JWToken.model.User;

public class UserMapper {

    // RequestDto -> Entity
    public static User toEntity(UserRequestDto dto) {
        if (dto == null) return null;

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        return user;
    }

    // Entity -> ResponseDto
    public static UserResponseDto toResponseDto(User user) {
        if (user == null) return null;

        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());

        return dto;
    }
}