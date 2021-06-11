<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- JSTL PREFIJO C -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>PROCESO DE ELECCIÓN</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"  style="background-color: #dc3545">
			<div>
				<a href="index2.jsp" class="navbar-brand"> ELECCIONES UFPS</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/EleccionServlet?action=list" class="nav-link">Elecciones </a></li>
			</ul>
		</nav>
	</header>
	
	<br>
	
	<div class="row">
		<div class="container">
			<h3 class="text-center">Listado de Elecciones </h3>
			<hr>
			
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/eleccionR.jsp" class="btn btn-danger">Nuevo Elecciones</a>
			</div>
			
			<br>
			
			<table class="table table-bordered">
				<thead>
					<tr>				
						<th>Id</th>											
						<th>Nombre</th>
						<th>Fecha Inicio </th>
						<th>Fecha Fin </th>
						<th>Cargo  </th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="eleccion" items="${listaEleccion}">
						<tr>
							<td><c:out value="${eleccion.id}" /></td>
							<td><c:out value="${eleccion.nombre}" /></td>
							<td><c:out value="${eleccion.fechainicio}" /></td>
							<td><c:out value="${eleccion.fechafin}" /></td>
							<td><c:out value="${eleccion.cargo}" /></td>
							<td>
								<a href="<%=request.getContextPath()%>/EleccionServlet?action=edit&id=<c:out value="${eleccion.id}" />">Editar</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="/UFPS/EleccionServlet/delete?id=<c:out value='${eleccion.id}' />">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
</body>
</html>