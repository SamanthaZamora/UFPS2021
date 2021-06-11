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
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: #dc3545"">
			<div>
				<a href="index2.jsp" class="navbar-brand"> ELECCIONES UFPS</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/EleccionServlet?action=list" class="nav-link"> Elecciones </a></li>
			</ul>
		</nav>
	</header>

    <br>

	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${Eleccion != null}">
					<form action="update" method="post">
				</c:if>

				<c:if test="${Eleccion == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${Eleccion != null}"> Editar Elección </c:if>

						<c:if test="${Eleccion == null}"> Insertar Elección  </c:if>
					</h2>
				</caption>

				<c:if test="${Eleccion != null}">
					<input type="hidden" name="id" value="<c:out value='${Eleccion.id}' />" />
				</c:if>

				<br>
		
				<fieldset class="form-group">
					<label>Nombre</label> <input type="text"
						value="<c:out value='${Eleccion.nombre}' />" class="form-control"
						name="nombre" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Fecha de Inicio</label> <input type="date"
						value="<c:out value='${Eleccion.fechainico}' />" class="form-control"
						name="fechainico" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Fecha de Finalización</label>
					 <input
												type="date" class="form-control" name="fechafin" required value="<c:out value='${Eleccion.fechainicio}'/>">
										
				</fieldset>

				
				<fieldset class="form-group">
					<label>Cargo</label> <input type="text"
						value="<c:out value='${Eleccion.cargo}' />" class="form-control"
						name="cargo" required="required">
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

