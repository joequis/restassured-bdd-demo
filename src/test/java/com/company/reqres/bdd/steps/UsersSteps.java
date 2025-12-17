
package com.company.reqres.bdd.steps;

import com.company.reqres.infra.config.ConfigLoader;
import com.company.reqres.service.UsersFlow;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    @Before
    public void beforeScenario() {
        String env = System.getProperty("env", "dev");
        ConfigLoader.load(env);
    }

    @When("consulto la lista de usuarios de la pagina {int}")
    public void consultoListaUsuarios(int page) {
        log.info("Listar los usuarios de la página {}", page);
        lastResponse = flow.listarUsuarios(page);
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

    @When("creo un usuario con Title {string}, Body {string} y Id {string}")
    public void creoUsuario(String title, String body1, String userId) {
        lastResponse = flow.crearUsuario(title, body1, userId);
    }

    @And("el nombre devuelto es {string} y el trabajo {string}")
    public void validarNombreYTrabajo(String expectedName, String expectedJob) {
        assertThat(lastResponse.jsonPath().getString("name")).isEqualTo(expectedName);
        assertThat(lastResponse.jsonPath().getString("job")).isEqualTo(expectedJob);
    }
}