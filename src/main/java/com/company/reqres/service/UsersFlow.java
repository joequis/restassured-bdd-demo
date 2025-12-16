
package com.company.reqres.service;

import com.company.reqres.client.UsersClient;
import com.company.reqres.model.users.CreateUserRequest;
import io.restassured.response.Response;

/**
 * Qué hace: Orquesta flujos de usuarios usando el cliente (p.ej., listar, crear).
 * De dónde obtiene data: Parámetros del Step (page, name, job).
 * Quién la usa: UsersSteps (definiciones de pasos de Cucumber).
 */
public class UsersFlow {
    private final UsersClient client = new UsersClient();

    public Response listarUsuarios(int page) {
        return client.listUsers(page);
    }

    public Response crearUsuario(String title, String body1, String userId) {
        var body = new CreateUserRequest(title, body1, userId);
        return client.createUser(body);
    }
}