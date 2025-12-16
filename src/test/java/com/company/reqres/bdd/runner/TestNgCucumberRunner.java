
package com.company.reqres.bdd.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Qué hace: Ejecuta los Features con Cucumber usando TestNG.
 * De dónde obtiene data: Los .feature ubicados en features/.
 * Quién la usa: Ejecución directa desde IntelliJ.
 */
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.company.reqres.bdd.steps",
        plugin = {
        "pretty",
        "summary",
        "html:target/cucumber-report.html",
        "json:target/cucumber-report.json"},
        monochrome = true,
        tags = ""
        )
public class TestNgCucumberRunner extends AbstractTestNGCucumberTests {

}