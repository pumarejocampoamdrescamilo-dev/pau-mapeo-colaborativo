<%-- Archivo : roles/formulario.jsp (MK-02)
     HU/RF   : HU-01 · RF-01
     v1.0 2026-10-27  creacion (RF-01)
     v1.1 2026-10-27  Cancelar vuelve al catalogo MK-01 (RF-02) --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Registrar rol · PAU</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body>
<header>PAU · Mapeo Colaborativo de Rutas Accesibles</header>
<main>
  <h1>Registrar rol</h1>

  <c:if test="${not empty mensaje}"><div class="mensaje ok"><c:out value="${mensaje}"/></div></c:if>
  <c:if test="${not empty error}"><div class="mensaje error"><c:out value="${error}"/></div></c:if>

  <form method="post" action="${pageContext.request.contextPath}/roles/guardar">
    <label for="nombre">Nombre del rol</label>
    <input type="text" id="nombre" name="nombre" maxlength="50" required value="<c:out value='${nombre}'/>">

    <label for="descripcion">Descripción (opcional)</label>
    <textarea id="descripcion" name="descripcion" rows="3" maxlength="255"><c:out value="${descripcion}"/></textarea>

    <label>Estado</label>
    <div class="solo-lectura">ACTIVO (un rol nuevo nace activo)</div>

    <div class="botones">
      <button type="submit">Guardar</button>
      <a class="boton secundario" href="${pageContext.request.contextPath}/roles">Cancelar</a>
    </div>
  </form>
</main>
</body>
</html>
