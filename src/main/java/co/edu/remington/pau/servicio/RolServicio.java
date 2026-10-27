/* Archivo : RolServicio.java
 * HU/RF   : HU-01, HU-02, HU-03, HU-36 · RF-01, RF-02, RF-03, RF-36
 * v1.0 2026-10-27  creacion (RF-01)
 * v1.1 2026-10-27  consultarRol y listarRoles (RF-02)
 * v1.2 2026-10-27  actualizarRol (RF-03)
 * v1.3 2026-10-27  cambiarEstado (RF-36)
 */
package co.edu.remington.pau.servicio;

import co.edu.remington.pau.modelo.EstadoRol;
import co.edu.remington.pau.modelo.Rol;
import co.edu.remington.pau.modelo.RolDAO;
import java.sql.SQLException;
import java.util.List;

/** Reglas de negocio del modulo de roles: las RN se validan aqui y nunca en la vista. */
public class RolServicio {

    public static final String MSG_NO_EXISTE = "No se encontró ningún rol con ese identificador.";

    private final RolDAO rolDAO = new RolDAO();

    /** RF-01 (CU-01): crea un rol. Devuelve el id generado. Aplica RN-01. */
    public int crearRol(String nombre, String descripcion) throws ReglaNegocioException, SQLException {
        Rol rol = new Rol(nombre, descripcion);
        if (rolDAO.existePorNombre(rol.getNombre())) {
            throw new ReglaNegocioException("Ya existe un rol con ese nombre.");
        }
        if (!rol.crearRol()) {
            throw new ReglaNegocioException(
                    "El nombre del rol es obligatorio (hasta 50 caracteres) y la descripción admite hasta 255.");
        }
        return rolDAO.insertar(rol);
    }

    /** RF-02 (CU-02): consulta un rol por su identificador. */
    public Rol consultarRol(int idRol) throws ReglaNegocioException, SQLException {
        Rol rol = rolDAO.buscarPorId(idRol);
        if (rol == null) {
            throw new ReglaNegocioException(MSG_NO_EXISTE);
        }
        return rol.consultarRol(idRol);
    }

    /** RF-02: catalogo completo de roles. */
    public List<Rol> listarRoles() throws SQLException {
        return rolDAO.listar();
    }

    /** RF-03 (CU-03): actualiza nombre y descripcion de un rol. Aplica RN-01 frente a los demas roles. */
    public void actualizarRol(int idRol, String nombre, String descripcion) throws ReglaNegocioException, SQLException {
        if (rolDAO.buscarPorId(idRol) == null) {
            throw new ReglaNegocioException(MSG_NO_EXISTE);
        }
        Rol rol = new Rol(idRol, nombre == null ? null : nombre.trim(),
                (descripcion == null || descripcion.isBlank()) ? null : descripcion.trim(),
                rolDAO.buscarPorId(idRol).getEstado());
        if (rolDAO.existeOtroConNombre(rol.getNombre(), idRol)) {
            throw new ReglaNegocioException("Ya existe un rol con ese nombre.");
        }
        if (!rol.actualizarRol()) {
            throw new ReglaNegocioException(
                    "El nombre del rol es obligatorio (hasta 50 caracteres) y la descripción admite hasta 255.");
        }
        rolDAO.actualizar(rol);
    }

    /** RF-36 (CU-36): activa o inactiva un rol. RN-16: nunca se elimina. RN-15: un rol inactivo no se asigna a usuarios nuevos; los actuales lo conservan. */
    public void cambiarEstado(int idRol, EstadoRol nuevoEstado) throws ReglaNegocioException, SQLException {
        Rol rol = rolDAO.buscarPorId(idRol);
        if (rol == null) {
            throw new ReglaNegocioException(MSG_NO_EXISTE);
        }
        if (!rol.cambiarEstado(nuevoEstado)) {
            throw new ReglaNegocioException(nuevoEstado == EstadoRol.INACTIVO
                    ? "El rol ya está inactivo." : "El rol ya está activo.");
        }
        rolDAO.actualizarEstado(rol);
    }
}
