
package com.company.reqres.service;

import com.company.reqres.client.UsersClient;
import com.company.reqres.model.users.CreateUserRequest;
import io.restassured.response.Response;

import com.company.reqres.mapper.UserMapper;
import com.company.reqres.model.users.CreateUserRequest;
import com.company.reqres.model.users.UserResponseDto;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;


/**
 * Qué hace: Orquesta flujos de usuarios usando el cliente (p.ej., listar, crear).
 * De dónde obtiene data: Parámetros del Step (page, name, job).
 * Quién la usa: UsersSteps (definiciones de pasos de Cucumber).
 */
public class UsersFlow {
    private final UsersClient client = new UsersClient();
    //private final Validator validator;

    /*
    public UsersFlow() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }*/

    // Listar usuarios (GET /)
    public Response listarUsuarios() {
        return client.listUsers();
    }

    // Crear usuario (POST /)
    public Response crearUsuario(String name, String username, String email) {
        var body = new CreateUserRequest(name, username, email);

        /*
        // Validación del DTO de entrada
        var violations = validator.validate(body);
        if (!violations.isEmpty()) {
            throw new IllegalArgumentException("DTO inválido: " + violations);
        }*/

        var bodyDto = UserMapper.toRequest(body);
        return client.createUser(bodyDto);
    }

    // Buscar usuario por username (GET /users?username=)
    public Response buscarUsuarioPorUsername(String username) {
        return client.getUsersByUsername(username);
    }

    // Buscar usuario por id (GET /id)
        //UserResponseDto
    public Response buscarUsuarioPorId(int id) {
        //Response resp = client.getUserById(id);
        //return UserMapper.fromResponse(resp)
        return client.getUserById(id);
    }

}