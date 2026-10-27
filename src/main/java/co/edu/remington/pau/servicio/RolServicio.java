/* Archivo : RolServicio.java
 * HU/RF   : HU-01 · RF-01
 * v1.0 2026-10-27  creacion (RF-01)
 */
package co.edu.remington.pau.servicio;

import co.edu.remington.pau.modelo.Rol;
import co.edu.remington.pau.modelo.RolDAO;
import java.sql.SQLException;

/** Reglas de negocio del modulo de roles: las RN se validan aqui y nunca en la vista. */
public class RolServicio {

    private final RolDAO rolDAO = new RolDAO();

    /** RF-01 (CU-01): crea un rol. Devuelve el id generado. Aplica RN-01. */
    public int crearRol(String nombre, String descripcion) throws ReglaNegocioException, SQLException {
        Rol rol = new Rol(nombre, descripcion);
        if (rolDAO.existePorNombre(rol.getNombre())) {
            throw new ReglaNegocioException("Ya existe un rol con ese nombre.");
        }
        if (!rol.crearRol()) {
            throw new ReglaNegocioException(
                    "El nombre del rol es obligatorio (hasta 50 caracteres) y la descripcion admite hasta 255.");
        }
        return rolDAO.insertar(rol);
    }
}
