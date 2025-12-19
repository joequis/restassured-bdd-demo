package com.company.reqres.infra.routes;

//Aca definimos los paths

public class Routes {

    // Constructor privado para evitar que la clase sea instanciada.
    private Routes() {
    }

    public static final String USERS = "/users";
    public static final String USER_BY_ID = "/users/{id}";
}