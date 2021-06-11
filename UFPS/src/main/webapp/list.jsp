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
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: #dc3545">
			<div>
				<a href="index2.jsp" class="navbar-brand"> ELECCIONES UFPS</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list" class="nav-link">Votantes </a></li>
			</ul>
		</nav>
	</header>
	
	<br>
	
	<div class="row">
		<div class="container">
			<h3 class="text-center">Listado de Votantes </h3>
			<hr>
			
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/new" class="btn btn-danger" >Nuevo Votante</a>
			</div>
			
			<br>
			
			<table class="table table-bordered">
				<thead>
					<tr>				
						<th>Id</th>											
						<th>Nombre del Votante</th>
						<th>Email </th>
						<th>Documento </th>
						<th>Tipo de Documento </th>
						<th>Elección </th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="votante" items="${listaVotante}">
						<tr>
							<td><c:out value="${votante.id}" /></td>
							<td><c:out value="${votante.nombre}" /></td>
							<td><c:out value="${votante.email}" /></td>
							<td><c:out value="${votante.documento}" /></td>
							<td><c:out value="${votante.tipodocumentoBean.descripcion}" /></td>
							<td><c:out value="${votante.eleccionBean.nombre}" /></td>
							<td>
								<a href="edit?id=<c:out value='${votante.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="delete?id=<c:out value='${votante.id}' />">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
</body>
</html>