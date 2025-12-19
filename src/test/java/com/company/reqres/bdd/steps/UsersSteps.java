
package com.company.reqres.bdd.steps;

import com.company.reqres.assertions.UserAssert;
import com.company.reqres.infra.config.ConfigLoader;
import com.company.reqres.model.users.UserResponseDto;
import com.company.reqres.service.UsersFlow;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Qué hace: Implementa los pasos del Feature y delega en UsersFlow.
 * De dónde obtiene data: Parámetros del Feature (page, name, job).
 * Quién la usa: Cucumber al ejecutar los escenarios de users.feature.
 */
public class UsersSteps {

    private static final Logger log = LoggerFactory.getLogger(UsersSteps.class);
    private final UsersFlow flow = new UsersFlow();

    private Response lastResponse;
    private UserResponseDto userDto;

    @Before
    public void beforeScenario() {
        String env = System.getProperty("env", "dev");
        ConfigLoader.load(env);
    }

    @When("consulto la lista de usuarios")
    public void consultoListaUsuarios() {
        log.info("Listar los usuarios");
        lastResponse = flow.listarUsuarios();
    }

    @Then("el codigo de estado es {int}")
    public void elCodigoDeEstadoEs(int expected) {
        log.info("El código de estado debe ser {}", expected);
        assertThat(lastResponse.statusCode()).isEqualTo(expected);
    }

    @And("la lista de usuarios no esta vacia")
    public void laListaDeUsuariosNoEstaVacia() {
        log.info("Valido que la lista no está vacia");
        assertThat(lastResponse.jsonPath().getList("data")).isNotEmpty();
    }

    @When("creo un usuario con Nombre {string}, Usuario {string} y Email {string}")
    public void creoUsuario(String name, String username, String email) {
        lastResponse = flow.crearUsuario(name, username, email);
    }

    @And("el nombre devuelto es {string} y el trabajo {string}")
    public void validarNombreYTrabajo(String expectedName, String expectedJob) {
        assertThat(lastResponse.jsonPath().getString("name")).isEqualTo(expectedName);
        assertThat(lastResponse.jsonPath().getString("job")).isEqualTo(expectedJob);
    }

    @When("busco el usuario por username {string}")
    public void buscoUsuarioPorUsername(String username) {
        lastResponse = flow.buscarUsuarioPorUsername(username);
    }

    @And("la respuesta contiene al menos un usuario")
    public void respuestaContieneAlMenosUnUsuario() {
        assertThat(lastResponse.jsonPath().getList("$")).isNotEmpty();
    }

    @And("el primer usuario tiene username {string}")
    public void primerUsuarioTieneUsername(String expectedUsername) {
        var jp = lastResponse.jsonPath();
        String actual = jp.getString("[0].username");
        assertThat(actual).isEqualTo(expectedUsername);
    }

    @When("busco el usuario por id {int}")
    public void buscoUsuarioPorId(int id) {
        //userDto = flow.buscarUsuarioPorId(id);
        lastResponse = flow.buscarUsuarioPorId(id);
        userDto = lastResponse.as(UserResponseDto.class);

    }

        @And("la respuesta del usuario incluye los parametros name, username y email")
        public void validarClavesBasicasUsuario() {


           // assertThat(userDto).as("El cuerpo debe mapear al DTO de usuario").isNotNull();
           // assertThat(userDto.name).as("name no debe ser nulo/blank").isNotBlank();
           // assertThat(userDto.username).as("username con formato permitido").matches("[A-Za-z0-9_]+");
           //s assertThat(userDto.email).as("email válido").matches("^[\\w.%+-]+@[\\w.-]+\\.[A-Za-z]{2,}$");



            //Uso de AssertJ
            UserAssert.assertThat(userDto).isValid();
        }


}