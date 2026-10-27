/* Archivo : ReglaNegocioException.java
 * HU/RF   : transversal (rechazo de reglas de negocio)
 * v1.0 2026-10-27  creacion (chore build)
 */
package co.edu.remington.pau.servicio;

/** Se lanza cuando una operacion incumple una regla de negocio; su mensaje se muestra al usuario. */
public class ReglaNegocioException extends Exception {

    private static final long serialVersionUID = 1L;

    public ReglaNegocioException(String mensaje) {
        super(mensaje);
    }
}
