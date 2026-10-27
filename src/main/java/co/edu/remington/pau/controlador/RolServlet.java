/* Archivo : RolServlet.java
 * HU/RF   : HU-01 · RF-01
 * v1.0 2026-10-27  creacion (RF-01)
 * v1.1 2026-10-27  rutas exactas: /roles/* capturaba tambien roles/formulario.jsp (RF-01)
 */
package co.edu.remington.pau.controlador;

import java.io.IOException;
import java.sql.SQLException;

import co.edu.remington.pau.servicio.ReglaNegocioException;
import co.edu.remington.pau.servicio.RolServicio;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/** Controlador del modulo de roles (MK-01 y MK-02). */
@WebServlet(urlPatterns = {"/roles", "/roles/nuevo", "/roles/guardar"})
public class RolServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final RolServicio servicio = new RolServicio();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("/roles/nuevo".equals(req.getServletPath())) {
            if ("1".equals(req.getParameter("ok"))) {
                req.setAttribute("mensaje", "Rol registrado correctamente.");
            }
            mostrarFormulario(req, resp);
        } else {
            // El listado de roles (MK-01) llega con RF-02; mientras tanto se muestra el formulario.
            resp.sendRedirect(req.getContextPath() + "/roles/nuevo");
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

    /** POST /roles/guardar: RF-01 crearRol(nombre, descripcion). */
    private void guardar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String descripcion = req.getParameter("descripcion");
        try {
            servicio.crearRol(nombre, descripcion);
            resp.sendRedirect(req.getContextPath() + "/roles/nuevo?ok=1");
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

    private void mostrarFormulario(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/roles/formulario.jsp").forward(req, resp);
    }
}