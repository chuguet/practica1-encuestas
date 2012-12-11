<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html> 
<html> 
	<head> 
		<title>Quizz Movember</title> 
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="resources/js/mobile/jquery.mobile-1.2.0.min.css" />
		<link href="resources/css/jquery-ui.css" rel="stylesheet" type="text/css" />
		<link href="resources/css/jquery.alerts.css" rel="stylesheet" type="text/css">
		
		<script type="text/javascript" src="resources/js/generic.js"></script>
		<script type="text/javascript" src="resources/js/jquery-1.8.2.min.js"></script>
		<script type="text/javascript" src="resources/js/mobile/jquery.mobile-1.2.0.min.js"></script>
		<script type="text/javascript" src="resources/js/jquery.alerts.js"></script>
		
	</head> 
	<body> 
	
		<div data-role="page">
			<div data-role="header">
				<h1>Encuestas</h1><a href="<c:url value="/j_spring_security_logout" />" title="Salir" id="btnSalir">Salir</a> 
			</div>
		
			<div data-role="content">	
				<h3>Usuario : ${username} ${authority}</h3>	
				<a href="javascript:void" onclick="javascript:generic.getList('rellenarEncuesta');" title="Ver encuestas disponibles">Ver encuestas disponibles</a>
				<img src="resources/imgs/encuesta.png" alt="imagenes" width="90%" />
			</div>
		
			<div data-role="footer" style="position:absolute; bottom:0px; font-size:0.7em;width:100%;text-align:center;">
				Movember S.L [Yamaradax & Huguet Association] &#174;
			</div>
		</div>
	
	</body>
</html>