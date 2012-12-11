<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<meta name="description" content="Pantalla de acceso al sistema" />
		<title>Acceso a Administraci&oacute;n de Quizz</title>
	
		<link href="resources/css/jquery-ui.css" rel="stylesheet" type="text/css" />
		<link href="resources/css/generic.css" rel="stylesheet" type="text/css" />
		<link href="resources/css/jquery.alerts.css" rel="stylesheet" type="text/css">
		<link href="resources/css/prettify.css" rel="stylesheet" type="text/css">
		
		<script src="resources/js/jquery-1.8.2.min.js" type="text/javascript"></script>
	    <script src="resources/js/jquery-ui-1.9.1.min.js" type="text/javascript"></script>
		<script src="resources/js/jquery.alerts.js" type="text/javascript"></script>
	</head>
	<body onload='document.f.j_username.focus();'>
		<form name='f' action="<c:url value='j_spring_security_check' />" method='POST'>
			<fieldset>
				<legend>Acceso a Quizz</legend>
				<p>
					<span>Usuario:</span><input type='text' name='j_username' value='' class="text ui-widget-content ui-corner-all" />
				</p>
				<p>
					<span>Contrase&ntilde;a:</span><input type='password' name='j_password'  class="text ui-widget-content ui-corner-all" />
				</p>
				<p>
					<input name="submit" type="submit" value="Aceptar" /><input name="reset" type="reset" value="Cancelar" />
				</p>
			</fieldset>
		</form>
	</body>
	<script type="text/javascript">
		<c:if test="${not empty error}">
		jAlert('${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}', 'Error');
		</c:if>
		$('input[type=submit]').button();
		$('input[type=reset]').button();
	</script>
</html>