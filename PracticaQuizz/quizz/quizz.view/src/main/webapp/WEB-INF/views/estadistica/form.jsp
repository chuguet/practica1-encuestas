<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript">
	function showInformationIntoView(registro){
		estadistica.mostrarEstadistica(registro);
	};
</script>

<fieldset id="estadistica">
	<legend class="quizzText">Resultados de la encuesta </legend>

</fieldset>
<c:if test="${mobile}">
<p style="text-align:center">
	<a href="#" id="btnVolver" data-role="button" data-inline="true" data-icon="check" data-mini="true" title="Ver encuestas disponibles">Volver al listado de encuestas</a>
</p>
</c:if>