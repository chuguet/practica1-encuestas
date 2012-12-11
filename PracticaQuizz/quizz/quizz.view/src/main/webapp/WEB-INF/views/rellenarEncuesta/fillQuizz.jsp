<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript">
	encuesta.formatForm();
	function showInformationIntoView(encuesta){
		$('#id').val(encuesta.id);
		$('#titulo').val(encuesta.nombre);
		for (var i= 0; i < encuesta.preguntasDTO.length; i++){
			var f = $('<fieldset />');
			var l = $('<legend />').text(preguntasDTO[i].title);
			$('preguntas').append(f);
		}
	};
</script>
<form id="alta">
	<input type="hidden" id="id" />
	<fieldset id="preguntas">
		<legend id="titulo"></legend>

	</fieldset>
</form>