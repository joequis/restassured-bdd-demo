
package com.company.reqres.infra.config;

import java.io.InputStream;
import java.util.Properties;

/**
 * Qué hace: Carga propiedades por ambiente (dev/qa) y expone getters.
 * De dónde obtiene data: src/test/resources/config*.properties
 * Quién la usa: HttpSpec, Steps (si necesitan baseUrl).
 */
public final class ConfigLoader {
    private static final Properties props = new Properties();

    public static void load(String env) {
        String file = "config.properties";
        if ("qa".equalsIgnoreCase(env)) file = "config.qa.properties"; //Valida ambiente

        //Valida existencia de archivo configuracion en ruta determinada
        try (InputStream is = ConfigLoader.class.getClassLoader().getResourceAsStream(file)) {
            if (is == null) throw new IllegalStateException("No se encontró " + file);
            props.load(is);
        } catch (Exception e) {
            throw new RuntimeException("Error cargando config: " + e.getMessage(), e);
        }
    }

    public static String get(String key) {
        String v = props.getProperty(key);
        if (v == null) throw new IllegalStateException("Propiedad faltante: " + key);
        return v;
    }

}