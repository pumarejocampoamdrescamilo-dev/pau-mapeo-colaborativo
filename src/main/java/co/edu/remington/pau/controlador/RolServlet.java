/* Archivo : RolServlet.java
 * HU/RF   : HU-01, HU-02 · RF-01, RF-02
 * v1.0 2026-10-27  creacion (RF-01)
 * v1.1 2026-10-27  rutas exactas: /roles/* capturaba tambien roles/formulario.jsp (RF-01)
 * v1.2 2026-10-27  listado y busqueda del catalogo, MK-01 (RF-02)
 */
package co.edu.remington.pau.controlador;

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
@WebServlet(urlPatterns = {"/roles", "/roles/nuevo", "/roles/guardar"})
public class RolServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final RolServicio servicio = new RolServicio();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("/roles/nuevo".equals(req.getServletPath())) {
            mostrarFormulario(req, resp);
        } else {
            listar(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        if ("/roles/guardar".equals(req.getServletPath())) {
            guardar(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    /** GET /roles: MK-01. Sin parametros lista el catalogo; con id consulta un rol (RF-02). */
    private void listar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("creado".equals(req.getParameter("msg"))) {
            req.setAttribute("mensaje", "Rol registrado correctamente.");
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

    /** POST /roles/guardar: RF-01 crearRol(nombre, descripcion). */
    private void guardar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String descripcion = req.getParameter("descripcion");
        try {
            servicio.crearRol(nombre, descripcion);
            resp.sendRedirect(req.getContextPath() + "/roles?msg=creado");
        } catch (ReglaNegocioException e) {
            req.setAttribute("error", e.getMessage());
            req.setAttribute("nombre", nombre);
            req.setAttribute("descripcion", descripcion);
            mostrarFormulario(req, resp);
        } catch (SQLException e) {
            getServletContext().log("Error al crear el rol", e);
            req.setAttribute("error", "No fue posible guardar el rol. Intente de nuevo.");
            req.setAttribute("nombre", nombre);
            req.setAttribute("descripcion", descripcion);
            mostrarFormulario(req, resp);
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
