var encuesta = {
	'formatView' : function() {
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

		$("#btnAddQuestion").button().click(function() {
			var tree = $("#tree").dynatree("getTree");
			if (tree.getActiveNode()) {
				tree.getActiveNode().deactivate();
			}
			$("#nombrePregunta").val('');
			$("#nombrePregunta").attr('key', '');
			$("#respuesta").val('');
			$('#respuestas').find('option').remove();
			$('#btnDeleteResponse').button("disable");
			$('#dialog-form').dialog('option', 'title', 'A&ntilde;adir Pregunta');
			$(".ui-dialog-buttonpane button:contains('Modificar') span").text('Crear');
			$("#dialog-form").dialog("open");
		});

		$("#btnModifyQuestion").button().click(function() {
			generic.xx();
		});

		$("#btnDeleteQuestion").button().click(function() {
			var tree = $("#tree").dynatree("getTree");
			var activeNode = tree.getActiveNode();
			activeNode.removeChildren();
			activeNode.remove();
		});

		$("#btnAddResponse").button().click(function() {
			var respuesta = $("#respuesta").val();
			if (respuesta.length == 0) {
				jAlert('No puede insertar respuestas vac&iacute;as', 'Error');
			}
			else {
				$('#respuestas').append('<option value="' + respuesta + '" key="">' + respuesta + '</option>');
				$("#respuesta").val('');
			}
		});
		$("#btnDeleteResponse").button().click(function() {
			$('#respuestas option:selected').remove();
		});

		$("#btnCancel").button().click(function() {
			generic.getList('encuesta');
		});

		$("#btnSaveQuizz").button().click(function() {
			generic.getParamsEncuesta();
		});

		$('#respuestas').change(function() {
			$('#btnDeleteResponse').button("enable");
		});

		$("#dialog-form").dialog({
			autoOpen : false,
			height : 400,
			width : 550,
			modal : true,
			buttons : {
				"Crear" : function() {
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
							title : this.value,
							key : this.getAttribute('key')
						});
					});

					var pregunta = [
						{
							title : $('#nombrePregunta').val(),
							isFolder : true,
							children : respuestas,
							key : $('#nombrePregunta').attr('key')
						}
					];
					if ($("#tree").dynatree("getTree").getActiveNode() != null) {
						$("#tree").dynatree("getRoot").addChild(pregunta, $("#tree").dynatree("getTree").getActiveNode());
						var newQuestion = $("#tree").dynatree("getTree").getActiveNode().getPrevSibling();
						if ($("#tree").dynatree("getTree").getActiveNode().isExpanded()) {
							newQuestion.expand();
						}
						$("#tree").dynatree("getTree").getActiveNode().remove();
						newQuestion.activate();
					}
					else {
						$("#tree").dynatree("getRoot").addChild(pregunta);
					}

					$(this).dialog("close");
					/*
					 * var bValid = true; allFields.removeClass(
					 * "ui-state-error" );
					 * 
					 * bValid = bValid && checkLength( name, "username", 3, 16 );
					 * bValid = bValid && checkLength( email, "email", 6, 80 );
					 * bValid = bValid && checkLength( password, "password", 5,
					 * 16 );
					 * 
					 * bValid = bValid && checkRegexp( name,
					 * /^[a-z]([0-9a-z_])+$/i, "Username may consist of a-z,
					 * 0-9, underscores, begin with a letter." ); // From
					 * jquery.validate.js (by joern), contributed by Scott
					 * Gonzalez:
					 * http://projects.scottsplayground.com/email_address_validation/
					 * bValid = bValid && checkRegexp( email,
					 * /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i,
					 * "eg. ui@jquery.com" ); bValid = bValid && checkRegexp(
					 * password, /^([0-9a-zA-Z])+$/, "Password field only allow :
					 * a-z 0-9" );
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
	}
};