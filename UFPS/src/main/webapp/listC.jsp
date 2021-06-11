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
				<li><a href="<%=request.getContextPath()%>/CandidatoServlet?action=list" class="nav-link">Candidatos </a></li>
			</ul>
		</nav>
	</header>
	
	<br>
	
	<div class="row">
		<div class="container">
			<h3 class="text-center">Listado de Candidatos </h3>
			<hr>
			
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/CandidatoServlet?action=new" class="btn btn-danger" >Nuevo Candidato</a>
			</div>
			
			<br>
			
			<table class="table table-bordered">
				<thead>
					<tr>				
						<th>Id</th>	
						<th>Documento </th>										
						<th>Nombre del Candidato</th>
						<th>Apellido del Candidato </th>
						<th>Elección </th>
						<th>Número </th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="candidato" items="${listCandidatos}">
						<tr>
							<td><c:out value="${candidato.id}" /></td>
							<td><c:out value="${candidato.documento}" /></td>
							<td><c:out value="${candidato.nombre}" /></td>
							<td><c:out value="${candidato.apellido}" /></td>
							<td><c:out value="${candidato.eleccionBean.nombre}" /></td>
							<td><c:out value="${candidato.numero}" /></td>
							<td>
								<a href="<%=request.getContextPath()%>/CandidatoServlet?action=edit&id=<c:out value='${candidato.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="CandidatoServlet?action=delete&id=<c:out value='${candidato.id}' />">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
</body>
</html>