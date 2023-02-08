<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="layout/header.jsp" />
<h1>${titulo}</h1>
<a class="btn btn-primary my-2" href="${pageContext.request.contextPath}/cursos/form">crear [+]</a>
<form action="${pageContext.request.contextPath}/cursos/buscar" method="post">
    <input type="text" name="nombre">
    <input type="submit" name="Buscar">
</form>

<table class="table table-hover table-striped">
    <tr>
        <th>id</th>
        <th>nombre</th>
        <th>instructor</th>
        <th>duracion</th>
        <th>editar</th>
        <th>eliminar</th>
    </tr>

    <c:forEach items="${cursos}" var="c">
    <tr>
        <td>${c.id}</td>
        <td>${c.nombre}</td>
        <td>${c.instructor}</td>
        <td>${c.duracion}</td>
        <td><a class="btn btn-sm btn-primary" href="${pageContext.request.contextPath}/cursos/form?id=${c.id}">editar</a></td>
        <td><a class="btn btn-sm btn-danger" onclick="return confirm('Esta seguro que desea eliminar?');"
        href="${pageContext.request.contextPath}/cursos/eliminar?id=${c.id}">eliminar</a></td>
    </tr>
    </c:forEach>
</table>
<jsp:include page="layout/footer.jsp" />
