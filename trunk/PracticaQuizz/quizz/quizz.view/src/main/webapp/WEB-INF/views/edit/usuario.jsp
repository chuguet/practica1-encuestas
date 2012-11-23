<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Alta de usuarios</title>
		<!-- 
		<link rel="stylesheet" href="../../css/jquery.mobile-1.0a4.1.min.css" />
		<link rel="stylesheet" href="../../css/bootstrap.min.css" />
		<link rel="stylesheet" href="../../css/bootstrap-responsive.min.css" />
		<link rel="stylesheet" href="../../css/no-more-tables.css" />
		<link rel="stylesheet" href="../../css/generic.css" />
		<link rel="stylesheet" href="../../css/jquery.gzoom.css" />
		
		<script type="text/javascript" src="../../js/jquery.mobile-1.0a4.1.min.js"></script>
		<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../../js/pretiffy.js"></script>
		 -->
		 <script type="text/javascript" src="../resources/js/jquery-1.5.2.min.js"></script>
		<style>
			#mine span {font-weight:bold;}
			#mine .foto{width:130px; height:130px; padding-top:10px;}
		</style>
	</head>
	<body id="mine"> 
		<div data-role="page" id="ppal_page">
			<div data-role="header">
				<h1>
					<c:choose>
						<c:when test="${usuario.id==null}">Alta</c:when>
						<c:otherwise>Edici&oacute;n</c:otherwise>
					</c:choose>
				    &nbsp;de usuario</h1>
			</div>
			
			<div data-role="content">
				<div><b>Nombre: </b><input type="text" id="nombre"<c:if test="${usuario.nombre!=null}"> value="${usuario.nombre}"</c:if>/></div>
				<div><b>Apellidos: </b><input type="text" id="apellidos"<c:if test="${usuario.apellidos!=null}"> value="${usuario.apellidos}"</c:if>/></div>
				<div><b>Email: </b><input type="text" id="email"<c:if test="${usuario.email!=null}"> value="${usuario.email}"</c:if>/></div>
				<div><b>Usuario: </b><input type="text" id="usuario"<c:if test="${usuario.usuario!=null}"> value="${usuario.usuario}"</c:if>/></div>
				<div><b>Contrase&ntilde;a: </b><input type="text" id="pwd"<c:if test="${usuario.pwd!=null}"> value="${usuario.pwd}"</c:if>/></div>
				<div><b>Es administrador: </b><input type="checkbox" id="admin" value="1" /></div>
				<div class="botonera">
					<c:choose>
						<c:when test="${usuario.id==null}"><input type="button" value="Guardar" /></c:when>
						<c:otherwise><input type="button" value="Modificar" />&nbsp;<input type="button" value="Eliminar" /></c:otherwise>
					</c:choose>
					&nbsp;<input type="button" value="Cancelar" onclick="$(location).attr('href','../usuario');"/>
				</div>
			</div>
	
			<div data-role="footer" data-position="fixed">
				<h1>MOVEMBER [Yamaradax & Huguet] S.L. &#174;</h1>
			</div>
		</div>
	</body>
</html>