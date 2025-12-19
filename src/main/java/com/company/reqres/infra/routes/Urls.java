package com.company.reqres.infra.routes;

public class Urls {

    private Urls() {
    }

    public static String getBaseUrl() {
        String env = System.getProperty("env", "dev"); // "dev" es el default

        switch (env.toLowerCase()) {
            case "qa":
                return "https://jsonplaceholder.typicode.com";
            case "dev":
            default:
                return "https://jsonplaceholder.typicode.com";
        }
    }
}
