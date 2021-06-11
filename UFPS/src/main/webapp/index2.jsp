<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Elecciones UFPS</title>
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
		</nav>
	</header>
	<center>
		<br>
		<h1>ELECCIONES UFPS 2021-2025</h1>
	</center>
	<br>
	<br>
	<div class="container">
		<div class="row">
			<div class="col">
				<div class="card" style="width: 18rem;">
					<img src="https://ichef.bbci.co.uk/news/640/cpsprodpb/674A/production/_102224462_venta_elecciones_mexico-nc.png" height="236"" class="card-img-top">
					<div class="card-body">
						<h5 class="card-title">Postulación para candidato</h5>
						<p class="card-text ">
							A través del Acuerdo No 15 de 2021 se convoca a la comunidad universitaria a la consulta
							democrática para definir los candidatos para el periodo 2021-2025 de la Universidad.
						</p>
						<div class="d-grid gap-2 col-6 mx-auto">
							<a href="<%=request.getContextPath()%>/CandidatoServlet?action=list" class="btn btn-danger ">Candidato</a>
						</div>
						
					</div>
				</div>
			</div>
			
			<div class="col">
				<div class="card" style="width: 18rem;">
					<img src="http://www.thenewstribe.com/wp-content/uploads/2013/04/E-voting1.jpg" height="236" class="card-img-top">
					<div class="card-body">
						<h5 class="card-title">Ejerce el derecho al voto</h5>
						<p class="card-text ">
							 Acuerdo No 18 de 2021 se adopta el mecanismo del voto electrónico para la consulta
							 democrática de los candidatos que conforman la lista del cargo de Rector para el periodo 2021-2025.
						</p>
						<div class="d-grid gap-2 col-6 mx-auto">
							<a href="<%=request.getContextPath()%>/list" class="btn btn-danger "> Votante</a>
						</div>
						
					</div>
				</div>
			</div>
			
			<div class="col">
				<div class="card" style="width: 18rem;">
					<img src="https://image.freepik.com/vector-gratis/dibujos-animados-mujeres-hombres-diseno-caja-votacion-dia-elecciones-votacion-gobierno_24877-69474.jpg" height="236" class="card-img-top">
					<div class="card-body">
						<h5 class="card-title">Elecciones vigentes</h5>
						<p class="card-text ">
							 Definición de los candidatos que se presentaran al Consejo Superior Universitario Francisco de Paula Santander para
							 la designación de Rector para el periodo 2021-2025 de la Universidad.
						</p>
						<div class="d-grid gap-2 col-6 mx-auto">
							<a href="<%=request.getContextPath()%>/EleccionServlet?action=list" class="btn btn-danger "> Elección</a>
						</div>
						
					</div>
				</div>
			</div>
		</div>
	</div>
	<br>
</body>
</html>