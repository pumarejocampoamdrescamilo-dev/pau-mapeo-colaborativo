/* Archivo : RolDAO.java
 * HU/RF   : HU-01, HU-02 · RF-01, RF-02
 * v1.0 2026-10-27  creacion (RF-01)
 * v1.1 2026-10-27  buscarPorId y listar (RF-02)
 */
package co.edu.remington.pau.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/** Acceso a datos de la tabla rol con JDBC. */
public class RolDAO {

    private static final String COLUMNAS = "SELECT id_rol, nombre, descripcion, estado FROM rol";

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

    /** RF-02: devuelve el rol con ese identificador, o nulo si no existe. */
    public Rol buscarPorId(int idRol) throws SQLException {
        String sql = COLUMNAS + " WHERE id_rol = ?";
        try (Connection cn = ConexionBD.obtener(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, idRol);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? mapear(rs) : null;
            }
        }
    }

    /** RF-02: todos los roles del catalogo, ordenados por identificador. */
    public List<Rol> listar() throws SQLException {
        String sql = COLUMNAS + " ORDER BY id_rol";
        List<Rol> roles = new ArrayList<>();
        try (Connection cn = ConexionBD.obtener();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                roles.add(mapear(rs));
            }
        }
        return roles;
    }

    private Rol mapear(ResultSet rs) throws SQLException {
        return new Rol(rs.getInt("id_rol"), rs.getString("nombre"), rs.getString("descripcion"),
                EstadoRol.valueOf(rs.getString("estado")));
    }
}
