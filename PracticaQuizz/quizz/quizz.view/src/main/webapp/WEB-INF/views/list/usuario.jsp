<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Movember S.L</title>
		<!--  
		<link rel="stylesheet" href="resources/css/jquery.mobile-1.0a4.1.min.css" />
		<link rel="stylesheet" href="resources/css/bootstrap.min.css" />
		<link rel="stylesheet" href="resources/css/bootstrap-responsive.min.css" />
		<link rel="stylesheet" href="resources/css/no-more-tables.css" />
		<link rel="stylesheet" href="resources/css/generic.css" />
		
		<script type="text/javascript" src="resources/js/jquery.mobile-1.0a4.1.min.js"></script>
		<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="resources/js/pretiffy.js"></script>
		-->
		<script type="text/javascript" src="resources/js/jquery-1.5.2.min.js"></script>
	</head>
	<body id="mine"> 
		<div data-role="page" id="ppal_page">
			<div data-role="header">
				<h1>Directorio de Usuarios</h1>
			</div>
			
			<div data-role="content" id="no-more-tables">
				<div class="botonera">
					<input type="button" value="Alta" onclick="$(location).attr('href','usuario/0');" />
				</div>
				<table class="table-bordered table-striped table-condensed cf">
					<thead>
						<tr>
							<th>ID</th>
							<th>Nombre</th>
							<th>Apellidos</th>
							<th>Email</th>
							<th>Usuario</th>
							<th>Es admin</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="usuario" items="${usuarios}">
						<tr onclick="window.location.href='usuario/${usuario.id}';">
							<td data-title="ID">${usuario.id}</td>
							<td data-title="Nombre">${usuario.nombre}</td>
							<td data-title="Apellidos">${usuario.apellidos}</td>
							<td data-title="Email">${usuario.email}</td>
							<td data-title="Usuario">${usuario.usuario}</td>
							<td data-title="Es admin">${usuario.admin}</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>	
			</div>
	
			<div data-role="footer" data-position="fixed">
				<h1>MOVEMBER [Yamaradax & Huguet] S.L. &#174;</h1>
			</div>
		</div>
	</body>	
</html>