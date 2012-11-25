<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form id="alta" modelAttribute="encuesta" action="javascript:generic.post('encuesta', generic.getParamsEncuesta());">
	<fieldset>
		<legend>Alta de Encuesta</legend>
		<p>
			<form:label path="nombre">Nombre:</form:label>
			<form:input path="nombre" maxlength="200" />
		</p>
		<p>
			<form:label path="fecha_inicio">Fecha de inicio:</form:label>
			<form:input path="fecha_inicio" />
		</p>
		<p>
			<form:label path="fecha_fin">Fecha de fin:</form:label>
			<form:input path="fecha_fin" />
		</p>
		<div class="botonera">
			<input type="submit" value="Guardar" />
			<input type="button" value="Cancelar" onclick="javascript:generic.get('encuesta');" />
		</div>
	</fieldset>
</form:form>
<script type="text/javascript">
$(function() {
    $("#fecha_inicio").datepicker();
    $("#fecha_fin").datepicker();
});
</script>
