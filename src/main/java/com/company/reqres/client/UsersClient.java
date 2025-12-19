
package com.company.reqres.client;

import com.company.reqres.infra.http.HttpSpec;
import com.company.reqres.infra.routes.Routes;
import com.company.reqres.model.users.CreateUserRequest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

/**
 * Qué hace: Llama a endpoints /api/users (GET listado, POST creación).
 * De dónde obtiene data: Request bodies (POJOs) y query params que recibe por método.
 * Quién la usa: UsersFlow (service) y, en última instancia, Steps (vía el flow).
 */
public class UsersClient {

    public Response listUsers() {
        return given()
                .spec(HttpSpec.base())
                //.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36")
                //.accept(ContentType.JSON)
                //.queryParam("page", page)
                .when()
                //.get("/api/users")
               // .get("/users")
                // .get("/api/users")

                //mejora UNO
                .get(Routes.USERS)
                .then()
                .log().body()
                .extract().response();
    }

    public Response createUser(CreateUserRequest body) {
        return given()
                .spec(HttpSpec.base())
                .body(body)
                .when()
                //.post("/api/users")
                //.post("/users")

                .post(Routes.USERS)
                .then()
                .log().body()
                .extract().response();
    }

    //GET /users?username={username}
    public Response getUsersByUsername(String username) {
        return given()
                .spec(HttpSpec.base())
                .log().params()
                .queryParam("username", username)
                .when()
                //.get("/users")
                .get(Routes.USERS)
                .then()
                .log().body()
                .extract().response();
    }

    //GET /users/{id}
    public Response getUserById(int id) {
        return given()
                .spec(HttpSpec.base())
                .when()
               // .get("/users/{id}", id)
                .get(Routes.USER_BY_ID, id)
                .then()
                .log().body()
                .extract().response();
    }


}