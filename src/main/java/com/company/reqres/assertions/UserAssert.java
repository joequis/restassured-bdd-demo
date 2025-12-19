package com.company.reqres.assertions;

import com.company.reqres.model.users.UserResponseDto;
import org.assertj.core.api.AbstractAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserAssert extends AbstractAssert<UserAssert, UserResponseDto> {

    private static final Logger log = LoggerFactory.getLogger(UserAssert.class);

    public UserAssert(UserResponseDto actual) {
        super(actual, UserAssert.class);
    }

    public static UserAssert assertThat(UserResponseDto actual) {
        return new UserAssert(actual);
    }

    public UserAssert isValid() {
        isNotNull();

        // Validar name
        if (actual.name == null || actual.name.isBlank()) {
            failWithMessage("Se esperaba que el nombre del usuario no fuera nulo ni vacío");
        }

        // Validar username
        if (actual.username == null || !actual.username.matches("[A-Za-z0-9_]+")) {
            failWithMessage("Username inválido <%s>. Sólo se permiten letras, números y guiones bajos.",
                    actual.username);
        }

        // Validar email
        if (actual.email == null || !actual.email.matches("^[\\w.%+-]+@[\\w.-]+\\.[A-Za-z]{2,}$")) {
            failWithMessage("Email inválido <%s>", actual.email);
        }

        return this;
    }


}
