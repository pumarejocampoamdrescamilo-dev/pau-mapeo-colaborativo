<%-- Archivo : roles/listado.jsp (MK-01)
     HU/RF   : HU-02, HU-03 · RF-02, RF-03
     v1.0 2026-10-27  creacion (RF-02)
     v1.1 2026-10-27  boton Editar por fila (RF-03) --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Catálogo de roles · PAU</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body>
<header>PAU · Mapeo Colaborativo de Rutas Accesibles</header>
<main>
  <h1>Catálogo de roles</h1>

  <c:if test="${not empty mensaje}"><div class="mensaje ok"><c:out value="${mensaje}"/></div></c:if>
  <c:if test="${not empty error}"><div class="mensaje error"><c:out value="${error}"/></div></c:if>

  <form method="get" action="${pageContext.request.contextPath}/roles" class="barra">
    <div class="campo">
      <label for="id">Buscar por identificador</label>
      <input type="text" id="id" name="id" value="<c:out value='${busqueda}'/>">
    </div>
    <button type="submit">Buscar</button>
    <a class="boton secundario" href="${pageContext.request.contextPath}/roles">Ver todos</a>
    <a class="boton" href="${pageContext.request.contextPath}/roles/nuevo">+ Nuevo rol</a>
  </form>

  <table class="tabla">
    <thead>
      <tr><th>ID</th><th>Nombre</th><th>Descripción</th><th>Estado</th><th>Acciones</th></tr>
    </thead>
    <tbody>
      <c:forEach var="r" items="${roles}">
        <tr>
          <td><c:out value="${r.idRol}"/></td>
          <td><c:out value="${r.nombre}"/></td>
          <td><c:out value="${r.descripcion}"/></td>
          <td class="${r.estado == 'ACTIVO' ? 'estado-activo' : 'estado-inactivo'}"><c:out value="${r.estado}"/></td>
          <td><a class="boton pequeno" href="${pageContext.request.contextPath}/roles/editar?id=${r.idRol}">Editar</a></td>
        </tr>
      </c:forEach>
      <c:if test="${empty roles}">
        <tr><td colspan="5" class="vacio">No hay roles para mostrar.</td></tr>
      </c:if>
    </tbody>
  </table>
</main>
</body>
</html>
