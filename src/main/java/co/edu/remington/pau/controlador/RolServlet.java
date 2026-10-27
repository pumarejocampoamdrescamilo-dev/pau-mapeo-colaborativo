/* Archivo : RolServlet.java
 * HU/RF   : HU-01, HU-02, HU-03, HU-36 · RF-01, RF-02, RF-03, RF-36
 * v1.0 2026-10-27  creacion (RF-01)
 * v1.1 2026-10-27  rutas exactas: /roles/* capturaba tambien roles/formulario.jsp (RF-01)
 * v1.2 2026-10-27  listado y busqueda del catalogo, MK-01 (RF-02)
 * v1.3 2026-10-27  editar y actualizar rol, MK-02 en modo edicion (RF-03)
 * v1.4 2026-10-27  cambiar estado de un rol desde MK-01 (RF-36)
 */
package co.edu.remington.pau.controlador;

import co.edu.remington.pau.modelo.EstadoRol;
import co.edu.remington.pau.modelo.Rol;
import co.edu.remington.pau.servicio.ReglaNegocioException;
import co.edu.remington.pau.servicio.RolServicio;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/** Controlador del modulo de roles (MK-01 y MK-02). */
@WebServlet(urlPatterns = {"/roles", "/roles/nuevo", "/roles/editar", "/roles/guardar", "/roles/estado"})
public class RolServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final RolServicio servicio = new RolServicio();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ruta = req.getServletPath();
        if ("/roles/nuevo".equals(ruta)) {
            mostrarFormulario(req, resp);
        } else if ("/roles/editar".equals(ruta)) {
            editar(req, resp);
        } else {
            listar(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String ruta = req.getServletPath();
        if ("/roles/guardar".equals(ruta)) {
            guardar(req, resp);
        } else if ("/roles/estado".equals(ruta)) {
            cambiarEstado(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    /** GET /roles: MK-01. Sin parametros lista el catalogo; con id consulta un rol (RF-02). */
    private void listar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("creado".equals(req.getParameter("msg"))) {
            req.setAttribute("mensaje", "Rol registrado correctamente.");
        } else if ("actualizado".equals(req.getParameter("msg"))) {
            req.setAttribute("mensaje", "Rol actualizado correctamente.");
        } else if ("inactivado".equals(req.getParameter("msg"))) {
            req.setAttribute("mensaje", "Rol inactivado correctamente.");
        } else if ("activado".equals(req.getParameter("msg"))) {
            req.setAttribute("mensaje", "Rol activado correctamente.");
        }
        String id = req.getParameter("id");
        try {
            List<Rol> roles;
            if (id == null || id.isBlank()) {
                roles = servicio.listarRoles();
            } else {
                roles = List.of(servicio.consultarRol(leerId(id)));
                req.setAttribute("busqueda", id.trim());
            }
            req.setAttribute("roles", roles);
        } catch (ReglaNegocioException e) {
            req.setAttribute("error", e.getMessage());
            req.setAttribute("busqueda", id);
            req.setAttribute("roles", List.<Rol>of());
        } catch (SQLException e) {
            getServletContext().log("Error al consultar los roles", e);
            req.setAttribute("error", "No fue posible consultar los roles. Intente de nuevo.");
            req.setAttribute("roles", List.<Rol>of());
        }
        req.getRequestDispatcher("/roles/listado.jsp").forward(req, resp);
    }

    /** POST /roles/estado: RF-36 cambia el estado de un rol y vuelve al catalogo. */
    private void cambiarEstado(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = leerId(req.getParameter("id"));
            EstadoRol nuevo = EstadoRol.valueOf(req.getParameter("estado"));
            servicio.cambiarEstado(id, nuevo);
            resp.sendRedirect(req.getContextPath() + "/roles?msg="
                    + (nuevo == EstadoRol.INACTIVO ? "inactivado" : "activado"));
        } catch (IllegalArgumentException | NullPointerException e) {
            req.setAttribute("error", "El estado solicitado no es válido.");
            mostrarListadoCompleto(req, resp);
        } catch (ReglaNegocioException e) {
            req.setAttribute("error", e.getMessage());
            mostrarListadoCompleto(req, resp);
        } catch (SQLException e) {
            getServletContext().log("Error al cambiar el estado del rol", e);
            req.setAttribute("error", "No fue posible cambiar el estado. Intente de nuevo.");
            mostrarListadoCompleto(req, resp);
        }
    }

    /** Muestra el catalogo completo junto con el mensaje de error ya cargado. */
    private void mostrarListadoCompleto(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("roles", servicio.listarRoles());
        } catch (SQLException e) {
            getServletContext().log("Error al listar los roles", e);
            req.setAttribute("roles", List.<Rol>of());
        }
        req.getRequestDispatcher("/roles/listado.jsp").forward(req, resp);
    }

    /** GET /roles/editar?id=N: MK-02 con los datos actuales del rol (RF-03). */
    private void editar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Rol rol = servicio.consultarRol(leerId(req.getParameter("id")));
            req.setAttribute("idRol", rol.getIdRol());
            req.setAttribute("nombre", rol.getNombre());
            req.setAttribute("descripcion", rol.getDescripcion());
            req.setAttribute("estado", rol.getEstado());
            mostrarFormulario(req, resp);
        } catch (ReglaNegocioException e) {
            req.setAttribute("error", e.getMessage());
            req.setAttribute("roles", List.<Rol>of());
            req.getRequestDispatcher("/roles/listado.jsp").forward(req, resp);
        } catch (SQLException e) {
            getServletContext().log("Error al consultar el rol", e);
            req.setAttribute("error", "No fue posible consultar el rol. Intente de nuevo.");
            req.setAttribute("roles", List.<Rol>of());
            req.getRequestDispatcher("/roles/listado.jsp").forward(req, resp);
        }
    }

    /** POST /roles/guardar: RF-01 crearRol (sin id) o RF-03 actualizarRol (con id). */
    private void guardar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String descripcion = req.getParameter("descripcion");
        String id = req.getParameter("idRol");
        boolean edicion = id != null && !id.isBlank();
        try {
            if (edicion) {
                servicio.actualizarRol(leerId(id), nombre, descripcion);
                resp.sendRedirect(req.getContextPath() + "/roles?msg=actualizado");
            } else {
                servicio.crearRol(nombre, descripcion);
                resp.sendRedirect(req.getContextPath() + "/roles?msg=creado");
            }
        } catch (ReglaNegocioException e) {
            req.setAttribute("error", e.getMessage());
            conservarEdicion(req, edicion, id);
            req.setAttribute("nombre", nombre);
            req.setAttribute("descripcion", descripcion);
            mostrarFormulario(req, resp);
        } catch (SQLException e) {
            getServletContext().log("Error al crear el rol", e);
            req.setAttribute("error", "No fue posible guardar el rol. Intente de nuevo.");
            conservarEdicion(req, edicion, id);
            req.setAttribute("nombre", nombre);
            req.setAttribute("descripcion", descripcion);
            mostrarFormulario(req, resp);
        }
    }

    /** Al fallar una edicion, el formulario debe seguir en modo edicion con el mismo rol. */
    private void conservarEdicion(HttpServletRequest req, boolean edicion, String id) {
        if (edicion) {
            req.setAttribute("idRol", id.trim());
            try {
                req.setAttribute("estado", servicio.consultarRol(leerId(id)).getEstado());
            } catch (ReglaNegocioException | SQLException e) {
                req.setAttribute("estado", null);
            }
        }
    }

    private int leerId(String texto) throws ReglaNegocioException {
        try {
            return Integer.parseInt(texto.trim());
        } catch (NumberFormatException e) {
            throw new ReglaNegocioException(RolServicio.MSG_NO_EXISTE);
        }
    }

    private void mostrarFormulario(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/roles/formulario.jsp").forward(req, resp);
    }
}
