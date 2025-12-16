
package com.company.reqres.model.users;

/**
 * Qué hace: Representa el JSON de entrada para crear usuario (POST /api/users).
 * De dónde obtiene data: Steps (parámetros del Feature).
 * Quién la usa: UsersClient.createUser().
 */

public class CreateUserRequest {
    //public String name;
    //public String job;
    public String title;
    public String body;
    public String userId;

    public CreateUserRequest() {}
    /*public CreateUserRequest(String name, String job) {
        this.name = name;
        this.job = job;
    }*/
        public CreateUserRequest(String title, String body,String userId) {
        this.title = title;
        this.body = body;
        this.userId = userId;
    }

}
