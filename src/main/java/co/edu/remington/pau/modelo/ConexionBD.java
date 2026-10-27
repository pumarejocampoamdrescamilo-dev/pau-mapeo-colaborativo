/* Archivo : ConexionBD.java
 * HU/RF   : transversal (acceso a datos con JDBC)
 * v1.0 2026-10-27  creacion (chore build)
 */
package co.edu.remington.pau.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Entrega conexiones JDBC a la base de datos pau. Los datos de conexion se leen
 * de variables de entorno (PAU_DB_URL, PAU_DB_USER y PAU_DB_PASSWORD); la clave
 * nunca se escribe en el codigo ni en el repositorio.
 */
public final class ConexionBD {

    private static final String URL = valor("PAU_DB_URL",
            "jdbc:mysql://localhost:3306/pau?useUnicode=true&characterEncoding=UTF-8");
    private static final String USUARIO = valor("PAU_DB_USER", "root");
    private static final String CLAVE = valor("PAU_DB_PASSWORD", "");

    private ConexionBD() {
    }

    private static String valor(String variable, String porDefecto) {
        String v = System.getenv(variable);
        return (v == null || v.isEmpty()) ? porDefecto : v;
    }

    public static Connection obtener() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se encontro el conector JDBC (carpeta lib).", e);
        }
        return DriverManager.getConnection(URL, USUARIO, CLAVE);
    }
}
