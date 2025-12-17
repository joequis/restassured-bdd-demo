package com.company.reqres.mapper;

import com.company.reqres.model.users.CreateUserRequest;
import com.company.reqres.model.users.UserResponseDto;
import io.restassured.response.Response;

public class UserMapper {

    /**
     * Construye el body del request directamente desde el DTO (a veces aquí limpias strings).
     * Normalizar acentos, caracteres especiales, remplazar datos, mayusculas, espacios en blanco, etc
     */
    public static CreateUserRequest toRequest(CreateUserRequest dto) {
        // Ejemplo de normalización:
        dto.name = dto.name.trim();
        dto.username = dto.username.trim();
        dto.email = dto.email.trim().toLowerCase();
        return dto;
    }

    /**
     * Mapea la respuesta JSON a User    /** Mapea la respuesta JSON a UserResponseDto.
     */
    public static UserResponseDto fromResponse(Response resp) {
        return resp.as(UserResponseDto.class);
    }
}