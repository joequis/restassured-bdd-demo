
package com.company.reqres.infra.http;

import com.company.reqres.infra.config.ConfigLoader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

/**
 * Qué hace: Construye la especificación base de RestAssured (baseUri, headers, timeouts).
 * De dónde obtiene data: ConfigLoader (base.url, timeout).
 * Quién la usa: Clients (UsersClient).
 */
public final class HttpSpec {
    private static RequestSpecification cached;

    public static RequestSpecification base() {
        if (cached == null) {
            String baseUrl = ConfigLoader.get("base.url");
            cached = new RequestSpecBuilder()
                    .setBaseUri(baseUrl)
                    .addHeader("Content-Type", "application/json; charset=UTF-8")
                    //.log(LogDetail.URI)
                    .log(LogDetail.ALL)
                    .build();
        }
        return cached;
    }
}
