<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- JSTL PREFIJO C -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Elecciones UFPS</title>
    <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
    <header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color:#dc3545">
			<div>
				<a href="index2.jsp" class="navbar-brand"> ELECCIONES UFPS</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/?action=list" class="nav-link"> Votantes </a></li>
			</ul>
		</nav>
	</header>

    <br>

	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${Votante != null}">
					<form action="update" method="post">
				</c:if>

				<c:if test="${Votante == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${Votante != null}"> Editar Votante </c:if>

						<c:if test="${Votante == null}"> Insertar Votante  </c:if>
					</h2>
				</caption>

				<c:if test="${Votante != null}">
					<input type="hidden" name="id" value="<c:out value='${Votante.id}' />" />
				</c:if>

				<br>
				<fieldset class="form-group">
					<label>Estamento</label> 
					<br> 
					<select	name="estamento" class="rounded form-control">
					<option value="">Seleccione el estamento al que pertenece</option>
						<c:forEach var="estamento" items="${estamento}">
							<option value="${estamento.id}">${estamento.descripcion }</option>
						</c:forEach>
					</select>
				</fieldset>
				
				<fieldset class="form-group">
					<label>Tipo de Documento</label> 
					<br> 
					<select	name="tipodocumento" class="rounded form-control">
						<option value="">Seleccione un tipo de documento</option>

					
						<c:forEach var="tipodocumento" items="${tipodocumento}">
							<option value="${tipodocumento.id}">${tipodocumento.descripcion}</option>
						</c:forEach>
					</select>
				</fieldset>
				
				<fieldset class="form-group">
					<label>Documento</label> <input type="text"
						value="<c:out value='${Votante.documento}' />" class="form-control"
						name="documento" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Nombre del Votante</label> <input type="text"
						value="<c:out value='${Votante.nombre}' />" class="form-control"
						name="nombre" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Email</label> <input type="email"
						value="<c:out value='${Votante.email}' />" class="form-control"
						name="email" required="required">
				</fieldset>


				<fieldset class="form-group">
					<label>Proceso</label> 
					<br> 
					<select	name="eleccion" class="rounded form-control">
					
						<option value="">Seleccione el proceso a votar</option>
						<c:forEach var="eleccion" items="${eleccion}">
							<option value="${eleccion.id}">${eleccion.nombre}</option>
						</c:forEach>
					</select>
				</fieldset>

				<br>
				<div class="d-grid gap-2 col-3 mx-auto">
					<button type="submit" class="btn btn-danger" >Guardar</button>
				</div>
				
				</form>
			</div>
		</div>
	</div>
	<br>
</body>
</html>

