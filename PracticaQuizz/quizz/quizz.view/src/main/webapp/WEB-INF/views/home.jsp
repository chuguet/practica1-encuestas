<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Quizz Movember</title>
	
	<link href="resources/css/jquery-ui.css" rel="stylesheet" type="text/css" />
	<link href="resources/css/generic.css" rel="stylesheet" type="text/css" />
	<link href="resources/css/ui.dynatree.css" rel="stylesheet" type="text/css">
	<link href="resources/css/prettify.css" rel="stylesheet" type="text/css">
	<link href="resources/css/jquery.alerts.css" rel="stylesheet" type="text/css">
	<link href="resources/css/ui.jqgrid.css" rel="stylesheet" type="text/css">
	
	<script src="resources/js/jquery.require.js" type="text/javascript"></script>
	<script src="resources/js/jquery.mobile-detect.min.js" type="text/javascript"></script>
	<script src="resources/js/jquery-1.8.2.min.js" type="text/javascript"></script>
	<script src="resources/js/jquery-ui-1.9.1.min.js" type="text/javascript"></script>
	<script src="resources/js/generic.js" type="text/javascript"></script>
	
	
	
  
  	<script src="resources/js/jquery.dynatree.js" type="text/javascript"></script>
	<!--  <script src="resources/js/prettify.js" type="text/javascript"></script>-->
	<script src="resources/js/jquery.alerts.js" type="text/javascript"></script>
	<script src="resources/js/jquery.jqGrid.min.js" type="text/javascript"></script>
	<script src="resources/js/i18n/grid.locale-es.js" type="text/javascript"></script>
	
	<script src="resources/js/views/encuesta.js" type="text/javascript"></script>
	<script src="resources/js/views/usuario.js" type="text/javascript"></script>
	<script src="resources/js/views/estadistica.js" type="text/javascript"></script>
</head>
<body id="quizz">
	<div id="ppal_page">
		<div id="header">
			<h1>Gestor de encuestas</h1>
		</div>
		
		<div id="menu">
			<sec:authorize ifAnyGranted="ROLE_ADMIN">
			<a href="javascript:void" onclick="javascript:generic.getList('usuario');" title="Ver usuarios">Usuarios</a>
			<a href="javascript:void" onclick="javascript:generic.getList('encuesta');" title="Ver encuestas">Encuestas</a>
			</sec:authorize>
			<a href="javascript:void" onclick="javascript:generic.getList('rellenarEncuesta');" title="Rellenar encuestas">Rellenar encuesta</a>
			
		</div>
		<div id="usuario">
			<h3>Usuario : ${username} ${authority}</h3>	
			<a href="<c:url value="/j_spring_security_logout" />" > Salir</a>
		</div>
		
		<div id="content">
			<img src="resources/imgs/encuesta.png" alt="imagenes" />
		</div>
		
		<div id="footer">
			<h1>Movember S.L [Yamaradax & Huguet Association] &#174;</h1>
		</div>
	</div>
</body>
</html>