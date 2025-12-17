
package com.company.reqres.model.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * Qué hace: Representa el JSON de entrada para crear usuario (POST /api/users).
 * De dónde obtiene data: Steps (parámetros del Feature).
 * Quién la usa: UsersClient.createUser().
 */

public class CreateUserRequest {
    //public String name;
    //public String job;
    //@NotBlank(message = "name es obligatorio")
    public String name;
    //@NotBlank(message = "username es obligatorio")
    public String username;
    //@Email(message = "email debe tener formato válido")
    //@NotBlank(message = "email es obligatorio")

    public String email;

    public CreateUserRequest() {}
    /*public CreateUserRequest(String name, String job) {
        this.name = name;
        this.job = job;
    }*/
        public CreateUserRequest(String name, String username, String email) {
        this.name = name;
        this.username = username;
        this.email = email;
    }

}
