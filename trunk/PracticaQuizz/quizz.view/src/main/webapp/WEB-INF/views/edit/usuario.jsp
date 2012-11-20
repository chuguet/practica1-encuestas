<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Empleado - ${empleado.nombre}</title>
		<link rel="stylesheet" href="../resources/css/jquery.mobile-1.0a4.1.min.css" />
		<link rel="stylesheet" href="../resources/css/bootstrap.min.css" />
		<link rel="stylesheet" href="../resources/css/bootstrap-responsive.min.css" />
		<link rel="stylesheet" href="../resources/css/no-more-tables.css" />
		<link rel="stylesheet" href="../resources/css/generic.css" />
		<link rel="stylesheet" href="../resources/css/jquery.gzoom.css" />
		<script type="text/javascript" src="../resources/js/jquery-1.5.2.min.js"></script>
		<script type="text/javascript" src="../resources/js/jquery.mobile-1.0a4.1.min.js"></script>
		<script type="text/javascript" src="../resources/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../resources/js/pretiffy.js"></script>
		<script type="text/javascript" src="../resources/js/jquery.gzoom.js"></script>
		<style>
			#mine span {font-weight:bold;}
			#mine .foto{width:130px; height:130px; padding-top:10px;}
		</style>
	</head>
	<body id="mine"> 
		<div data-role="page" id="ppal_page">
			<div data-role="header">
				<h1>Directorio de Empleados</h1>
			</div>
			
			<div data-role="content">
				<ul>
					<li><span>ID:</span> ${empleado.id}</li>
					<li><span>Nombre:</span> ${empleado.nombre}</li>
					<li><span>Email:</span> ${empleado.email}</li>
					<li><span>Tel&eacute;fono:</span> ${empleado.telefono}</li>
					<li><span>M&oacute;vil:</span> ${empleado.movil}</li>
					<li><span>Direcci&oacute;n:</span> ${empleado.direccion}</li>
				</ul>
				<div id="zoom04">
				<img src="../resources/imgs/${empleado.image}" title="Imagen de ${empleado.nombre}"/>
				</div>
			</div>
	
			<div data-role="footer" data-position="fixed">
				<h1>MOVEMBER [Yamaradax & Huguet] S.L. &#174;</h1>
			</div>
		</div>
	</body>	
	<script type="text/javascript">
		$("#zoom04").gzoom({sW: 200, sH: 200, lW: 1024, lH: 768, lightbox: true});
	</script>
	
</html>