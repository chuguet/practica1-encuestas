<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:choose>
	<c:when test="${mobile}">
	<head> 
		<title>Quizz Movember</title> 
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="resources/js/mobile/jquery.mobile-1.2.0.min.css" />
		<link href="resources/css/jquery.alerts.css" rel="stylesheet" type="text/css">
		
		<script type="text/javascript" src="resources/js/generic.js"></script>
		<script type="text/javascript" src="resources/js/jquery-1.8.2.min.js"></script>
		<script type="text/javascript" src="resources/js/mobile/jquery.mobile-1.2.0.min.js"></script>
		<script type="text/javascript" src="resources/js/jquery.alerts.js"></script>
		<script type="text/javascript" src="resources/js/views/rellenarEncuesta.js"></script>
		<script type="text/javascript" src="resources/js/mobile/jquery.mobile.js"></script>
		<style>
			.custom-header
			{
			    height:18px;
			}
			.header-title
			{
			    position:relative;
			    top:-10px;
			}
			.header-btn-left-pos1
			{
			    position:absolute;
			    left:25px;
			    top:5px;
			    z-index:1;
			}
			.header-btn-left-pos2
			{
			    position:absolute;
			    right:25px;
			    top:5px;
			    z-index:2;
			}
		</style>
	</head> 
	<body> 
		<div data-role="page" id="page">
			<input type="hidden" id="id_usuario" value="${id_usuario}" />
			<input type="hidden" id="ip_usuario" value="${ip_usuario}" />
			<div data-role="header">
				<div id="home-btn" class="header-btn-left-pos1">
			        <a href="javascript:window.location.reload();" data-role="button" data-icon="home" data-rel="home" data-iconpos="notext">Home</a>
			        
			    </div>
			
			    <div id="back-btn" class="header-btn-left-pos2">
			        <a href="<c:url value="/j_spring_security_logout" />" data-role="button" data-icon="delete" data-rel="delete" title="Salir" id="btnSalir" data-iconpos="notext">Salir</a>
			    </div>
			
			    <div class="header-title" align="center">
			        <h4>Encuestas</h4>
			    </div>
			
				<!-- <h1>Encuestas</h1><a href="<c:url value="/j_spring_security_logout" />" title="Salir" id="btnSalir">Salir</a> --> 
			</div>
		
			<div data-role="content" id="content">	
				<h3>Usuario : ${nombre}  ${apellidos}</h3>	
				<a href="javascript:void" onclick="javascript:generic.getList('rellenarEncuesta', rellenarEncuesta.getUser());" title="Ver encuestas disponibles">Ver encuestas disponibles</a>
				
				<img src="resources/imgs/encuesta.png" alt="imagenes" width="90%" />
			</div>
		
			<div data-role="footer" style="position:absolute; bottom:0px; font-size:0.7em;width:100%;text-align:center;">
				Movember S.L [Yamaradax & Huguet Association] &#174;
			</div>
		</div>
	
	</body>
	
	<!-- MOBILE -->
	</c:when>
	<c:otherwise>
	<!-- WEB -->

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
	<!-- WEB -->
	</c:otherwise>
</c:choose>
</html>