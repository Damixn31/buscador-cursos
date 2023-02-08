<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="layout/header.jsp" />
<h1>${titulo}</h1>
<a class="btn btn-secondary my-2" href="${pageContext.request.contextPath}/cursos">volver</a>
<form action="${pageContext.request.contextPath}/cursos/form" method="post">

    <div class="row mb-2">
        <label for="nombre" class="col-form-label col-sm-2">Nombre</label>
        <div class="col-sm-4">
            <input type="text" name="nombre" id="nombre" value="${curso.nombre}" class="form-control">
        </div>
        <c:if test="${errores != null && errores.containsKey('nombre')}">
            <div style="color:red;">${errores.nombre}</div>
        </c:if>
    </div>

    <div class="row mb-2">
        <label for="instructor" class="col-form-label col-sm-2">Instructor</label>
        <div class="col-sm-4">
            <input type="text" name="instructor" id="instructor" value="${curso.instructor}" class="form-control">
        </div>
       <c:if test="${errores != null && errores.containsKey('instructor')}">
           <div style="color:red;">${errores.instructor}</div>
       </c:if>
    </div>

    <div class="row mb-2">
        <label for="duracion" class="col-form-label col-sm-2">Duracion</label>
        <div class="col-sm-4">
            <input type="number" name="duracion" id="duracion" value="${curso.duracion > 0 ? curso.duracion : ""}" class="form-control">
        </div>
        <c:if test="${errores != null && not empty errores.duracion}">
              <div style="color:red;">${errores.duracion}</div>
        </c:if>
    </div>

    <div class="row mb-2">
        <label for="descripcion" class="col-form-label col-sm-2">Descripcion</label>
        <div class="col-sm-4">
            <textarea name="descripcion" id="descripcion" class="form-control">${curso.descripcion != null ? curso.descripcion : ""}</textarea>
        </div>
        <c:if test="${errores != null && errores.containsKey('descripcion')}">
            <div style="color:red;">${errores.descripcion}</div>
        </c:if>
    </div>

  <div class="row mb-2">
    <div>
       <input class="btn btn-primary" type="submit" value="${curso.id != null && curso.id > 0 ? "Editar" : "Crear"}">
    </div>
  </div>
    <input type="hidden" name="id" value="${curso.id}">
</form>
<jsp:include page="layout/footer.jsp" />
