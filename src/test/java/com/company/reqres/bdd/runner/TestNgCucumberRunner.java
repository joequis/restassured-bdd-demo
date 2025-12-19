
package com.company.reqres.bdd.runner;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import net.serenitybdd.cucumber.CucumberWithSerenity;

/**
 * Qué hace: Ejecuta los Features con Cucumber usando TestNG.
 * De dónde obtiene data: Los .feature ubicados en features/.
 * Quién la usa: Ejecución directa desde IntelliJ.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.company.reqres.bdd.steps",
        plugin = {
        "pretty",
        "summary",
        "html:target/cucumber-report.html",
        "json:target/cucumber-report.json"},
        monochrome = true,
        tags = "@Api-Usuarios"
        )
public class TestNgCucumberRunner {

}