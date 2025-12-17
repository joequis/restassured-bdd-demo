package com.company.reqres.model.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DTO de salida para lecturas de usuario (GET).
 * Sólo mapea campos necesarios. Ignora los extra.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponseDto {
    @JsonProperty("id")
    public Integer id;

    @JsonProperty("name")
    public String name;

    @JsonProperty("username")
    public String username;

    @JsonProperty("email")
    public String email;

    public UserResponseDto() {}
}

