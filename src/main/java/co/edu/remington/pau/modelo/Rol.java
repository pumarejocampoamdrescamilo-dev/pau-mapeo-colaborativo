/* Archivo : Rol.java
 * HU/RF   : HU-01, HU-02, HU-03 · RF-01, RF-02, RF-03
 * v1.0 2026-10-27  creacion (RF-01)
 * v1.1 2026-10-27  consultarRol (RF-02)
 * v1.2 2026-10-27  actualizarRol (RF-03)
 */
package co.edu.remington.pau.modelo;

/** Clase del dominio Rol (tabla rol). La llave idRol no tiene setter: la asigna la base de datos. */
public class Rol {

    private int idRol;
    private String nombre;
    private String descripcion;
    private EstadoRol estado;

    /** Rol nuevo, aun sin guardar: nace ACTIVO. */
    public Rol(String nombre, String descripcion) {
        this.nombre = (nombre == null) ? null : nombre.trim();
        this.descripcion = (descripcion == null || descripcion.isBlank()) ? null : descripcion.trim();
        this.estado = EstadoRol.ACTIVO;
    }

    /** Rol leido de la base de datos. */
    public Rol(int idRol, String nombre, String descripcion, EstadoRol estado) {
        this.idRol = idRol;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getIdRol() {
        return idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public EstadoRol getEstado() {
        return estado;
    }

    /** RF-01: valida los datos del rol segun el diccionario (nombre obligatorio de hasta 50, descripcion de hasta 255) y lo deja ACTIVO. */
    public boolean crearRol() {
        if (nombre == null || nombre.isBlank() || nombre.length() > 50) {
            return false;
        }
        if (descripcion != null && descripcion.length() > 255) {
            return false;
        }
        this.estado = EstadoRol.ACTIVO;
        return true;
    }

    /** RF-02: devuelve este rol si su identificador es el consultado; si no, nulo. La busqueda en la base de datos la hace RolDAO.buscarPorId. */
    public Rol consultarRol(int idRol) {
        return this.idRol == idRol ? this : null;
    }

    /** RF-03: valida los datos ya cambiados del rol con las mismas reglas del diccionario. El estado no cambia aqui (eso es RF-36). */
    public boolean actualizarRol() {
        if (idRol <= 0) {
            return false;
        }
        if (nombre == null || nombre.isBlank() || nombre.length() > 50) {
            return false;
        }
        return descripcion == null || descripcion.length() <= 255;
    }
}
