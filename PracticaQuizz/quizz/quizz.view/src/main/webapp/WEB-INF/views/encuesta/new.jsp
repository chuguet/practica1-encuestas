<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript">
	$(function() {
		var datePickerParams = {
			"dateFormat" : 'dd/mm/yy',
			"dayNamesMin" : [
					"D", "L", "M", "X", "J", "V", "S"
			],
			"firstDay" : 1,
			"monthNames" : [
					"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
			]
		};
		$("#fecha_inicio").datepicker(datePickerParams);
		$("#fecha_fin").datepicker(datePickerParams);
		generic.generateQuestionsTree("#tree");

		$("#addQuestion").button().click(function() {
			$("#nombrePregunta").val('');
			$("#respuesta").val('');
			$('#respuestas').find('option').remove();
			$("#dialog-form").dialog("open");
		});

		$("#addRespuesta").button().click(function() {
			var respuesta = $("#respuesta").val();
			if (respuesta.length == 0) {
				jAlert('No puede insertar respuestas vac&iacute;as', 'Error');
			}
			else {
				$('#respuestas').append('<option value="'+ respuesta + '">' + respuesta + '</option>');
				$("#respuesta").val('');
			}
		});

		$("#cancelQuizz").button().click(function() {
			generic.getList('encuesta');
		});

		$("#saveQuizz").button().click(function() {
			generic.getParamsEncuesta();
		});

		$("#dialog-form").dialog({
			autoOpen : false,
			height : 400,
			width : 550,
			modal : true,
			buttons : {
				"Crear Pregunta" : function() {
					if ($('#nombrePregunta').val().length == 0) {
						jAlert('No puede insertar preguntas vac&iacute;as', 'Error');
						return;
					}
					if ($('#respuestas option').length < 2) {
						jAlert('Debe a&ntildeadir al menos dos respuestas para la pregunta', 'Error');
						return;
					}
					var respuestas = [];
					$("#respuestas option").each(function() {
						respuestas.push({
							title : this.value
						});
					});

					var pregunta = [
						{
							title : $('#nombrePregunta').val(),
							isFolder : true,
							children : respuestas
						}
					];
					$("#tree").dynatree("getRoot").addChild(pregunta);
					$(this).dialog("close");
					/*
					var bValid = true;
					allFields.removeClass( "ui-state-error" );

					bValid = bValid && checkLength( name, "username", 3, 16 );
					bValid = bValid && checkLength( email, "email", 6, 80 );
					bValid = bValid && checkLength( password, "password", 5, 16 );

					bValid = bValid && checkRegexp( name, /^[a-z]([0-9a-z_])+$/i, "Username may consist of a-z, 0-9, underscores, begin with a letter." );
					// From jquery.validate.js (by joern), contributed by Scott Gonzalez: http://projects.scottsplayground.com/email_address_validation/
					bValid = bValid && checkRegexp( email, /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i, "eg. ui@jquery.com" );
					bValid = bValid && checkRegexp( password, /^([0-9a-zA-Z])+$/, "Password field only allow : a-z 0-9" );
					 */

				},
				Cancel : function() {
					$(this).dialog("close");
				}
			},
			close : function() {
				allFields.val("");
			}
		});
	});
</script>
<form id="alta">
	<fieldset>
		<legend>
		<c:choose>
			<c:when test="${operacion == 'new'}">Alta de Encuesta</c:when>
			<c:otherwise>Edici&oacute;n de Encuesta</c:otherwise>
		</c:choose>
		</legend>
		<input type="hidden" id="id" />
		<p>
			<label for="nombre">Nombre:</label>
			<input id="nombre" maxlength="200" class="text ui-widget-content ui-corner-all" />
		</p>
		<p>
			<label for="fecha_inicio">Fecha de inicio:</label>
			<input id="fecha_inicio" class="text ui-widget-content ui-corner-all" />
		</p>
		<p>
			<label for="fecha_fin">Fecha de fin:</label>
			<input id="fecha_fin" class="text ui-widget-content ui-corner-all" />
		</p>
		<fieldset style="height: 200px;">
			<legend>Preguntas</legend>
			<div id="tree" style="height: 180px;"></div>
		</fieldset>
		<div class="botonera">
			<c:choose>
				<c:when test="${operacion == 'new'}">
					<input type="button" id="saveQuizz" value="Guardar" />
				</c:when>
				<c:otherwise>
					<input type="button" id="saveQuizz" value="Modificar" />
				</c:otherwise>
			</c:choose>
			<input type="button" id="cancelQuizz" value="Cancelar" /> 
			<input type="button" id="addQuestion" value="Añadir pregunta" />
		</div>
	</fieldset>
</form>

<div id="dialog-form" title="A&ntilde;adir Pregunta">
	<form id="frmPreguntas">
		<label for="nombrePregunta">Pregunta</label><br /> 
		<input type="text" name="nombrePregunta" id="nombrePregunta" class="text ui-widget-content ui-corner-all" /> 
		<label for="respuesta">Respuesta</label><br /> 
		<input type="text" name="respuesta" id="respuesta" value="" class="text ui-widget-content ui-corner-all" />
		<input type="button" id="addRespuesta" value="A&ntilde;adir respuesta" /> 
		<label for="respuestas">Respuestas</label><br /> 
		<select size="8" id="respuestas" name="respuestas" />
	</form>
</div>