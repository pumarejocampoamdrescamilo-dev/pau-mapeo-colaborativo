/* Archivo : RolDAO.java
 * HU/RF   : HU-01 · RF-01
 * v1.0 2026-10-27  creacion (RF-01)
 */
package co.edu.remington.pau.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** Acceso a datos de la tabla rol con JDBC. */
public class RolDAO {

    /** RN-01: indica si ya existe un rol con ese nombre. */
    public boolean existePorNombre(String nombre) throws SQLException {
        String sql = "SELECT 1 FROM rol WHERE nombre = ?";
        try (Connection cn = ConexionBD.obtener(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, nombre);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    /** Inserta el rol y devuelve el id generado por la base de datos. */
    public int insertar(Rol rol) throws SQLException {
        String sql = "INSERT INTO rol (nombre, descripcion, estado) VALUES (?, ?, ?)";
        try (Connection cn = ConexionBD.obtener();
             PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, rol.getNombre());
            ps.setString(2, rol.getDescripcion());
            ps.setString(3, rol.getEstado().name());
            ps.executeUpdate();
            try (ResultSet claves = ps.getGeneratedKeys()) {
                return claves.next() ? claves.getInt(1) : 0;
            }
        }
    }
}
