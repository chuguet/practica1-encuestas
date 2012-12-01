var generic = {
	"uri" : "http://localhost:8080/com.movember.quizz.view/rest/",
	"getList" : function(entity) {
		var action = entity + '/form/list';
		this.executeHtml('GET', action, function() {
			generic.get(entity, null, generic.showInformation);
		});
	},
	"getForm" : function(entity, item) {
		if (item) {
			var action = entity + '/form/edit';
			this.executeHtml('GET', action, function() {
				generic.get(entity, item, generic.showInformation);
			});
		}
		else {
			var action = entity + '/form/new';
			this.executeHtml('GET', action, null);
		}
	},
	"get" : function(entity, item, callback) {
		var action = entity;
		if (item && item != null) {
			action += '/' + item;
		}
		this.executeJSon('GET', action, null, callback);
	},
	"post" : function(action, params, callback) {
		this.executeJSon('POST', action, params, callback);
	},
	"put" : function(action, params, callback) {
		this.executeJSon('PUT', action, params, callback);
	},
	"delete" : function(entity, id, callback) {
		var params = {
			'id' : id
		};
		this.executeJSon('DELETE', entity, params, callback);
	},
	"executeJSon" : function($method, action, data, callback) {
		if (data != null) {
			data = JSON.stringify(data);
		}
		$.ajaxSetup({
			headers : {
				"Content-Type" : 'application/json',
				"Accept" : 'application/json'
			}
		});
		$.ajax({
			type : $method,
			url : this.uri + action,
			data : data,
			dataType : 'json',
			// contentType : content_type,
			// dataType : 'html',
			success : function(response) {
				if ($method == 'GET') {
					if (callback) {
						var param = new Array();
						param.push(response);
						callback.apply(this, param);
					}
				}
				else {
					jAlert(response.mensaje, 'Operación correcta');
					if (response.correcto) {
						if (callback) {
							var param = new Array();
							param.push(response);
							callback.apply(this, param);
						}
					}
				}
			},
			error : function(e) {
				jAlert('Se ha producido un error al procesar la acción', 'Error de operación');
			}
		});
	},
	"executeHtml" : function($method, action, callback) {
		$.ajaxSetup({
			headers : {
				"Content-Type" : 'text/html;charset=UTF-8',
				"Accept" : 'text/html;charset=UTF-8'
			}
		});
		$.ajax({
			type : $method,
			url : this.uri + action,
			dataType : 'html',
			success : function(response) {
				$('#content').html(response);
				if (callback) {
					callback.apply(this, arguments);
				}
			},
			error : function(e) {
				alert(e);
				jAlert('Se ha producido un error al acceder a la p&aacute;gina');
			}
		});
	},
	'getParamsUsuario' : function() {
		var id = ($("#id").val()) ? $("#id").val() : null;
		var data = {
			'id' : id,
			'nombre' : $("#nombre").val(),
			'apellidos' : $("#apellidos").val(),
			'email' : $("#email").val(),
			'usuario' : $("#usuario").val(),
			'pwd' : $("#pwd").val(),
			'admin' : ($("#admin1").is(':checked')) ? 1 : 0
		};
		return data;
	},
	'getParamsEncuesta' : function() {
		var id = ($("#id").val()) ? $("#id").val() : null;
		var dInicio = $("#fecha_inicio").datepicker('getDate');
		var fecha_inicio = dInicio.getFullYear() + '-' + (dInicio.getMonth() + 1) + '-' + dInicio.getDate();
		var dFin = $("#fecha_fin").datepicker('getDate');
		var fecha_fin = dFin.getFullYear() + '-' + (dFin.getMonth() + 1) + '-' + dFin.getDate();
		var data = {
			id : id,
			nombre : $("#nombre").val(),
			fecha_inicio : fecha_inicio,
			fecha_fin : fecha_fin,
			preguntasDTO : generic.getQuestions()
		};
		var entity = (id != null) ? 'encuesta/' + id : 'encuesta';
		generic.post(entity, data, function() {
			generic.getList('encuesta');
		});
	},
	'generateQuestionsTree' : function(selector) {
		$(selector).dynatree({
			selectMode : 1,
			onActivate : function(question) {
				$("#btnModifyQuestion").button("enable");
				$("#btnDeleteQuestion").button("enable");
			}
		});
	},
	'xx' : function() {
		var xz = $("#tree").dynatree("getRoot");
		var tree = $("#tree").dynatree("getTree");
		var selectedQuestion = tree.getActiveNode();
		$("#nombrePregunta").val(selectedQuestion.data.title);
		$("#nombrePregunta").attr('key', selectedQuestion.data.key);
		$('#respuestas').find('option').remove();
		$('#btnDeleteResponse').button("disable");
		var responses = selectedQuestion.childList;
		for( var i = 0; i < responses.length; i++) {
			$('#respuestas').append('<option value="' + responses[i].data.title + '" key="' + responses[i].data.key + '">' + responses[i].data.title + '</option>');
		}
		$('#dialog-form').dialog('option', 'title', 'Modificar Pregunta');
		$(".ui-dialog-buttonpane button:contains('Crear') span").text('Modificar');
		$("#dialog-form").dialog("open");
	},
	'getQuestions' : function() {
		if ($("#tree").dynatree("getTree").toDict().children) {
			var preguntas = [];
			var pregArray = $("#tree").dynatree("getTree").toDict().children;
			for( var i = 0; i < pregArray.length; i++) {
				var p = pregArray[i];
				var respuestas = [];
				var respArray = p.children;
				for( var j = 0; j < respArray.length; j++) {
					var respuesta = {
						'id' : null,
						'title' : respArray[j].title,
						'key' : respArray[j].key,
						'isFolder' : false
					};
					respuestas.push(respuesta);
				}

				var pregunta = {
					'id' : null,
					'title' : p.title,
					'key' : p.key,
					'isFolder' : true,
					'children' : respuestas
				};
				preguntas.push(pregunta);
			}
			return preguntas;
		}
		else {
			var preguntas = new Array();
			preguntas.push({
				id : null,
				title : "Pregunta1",
				key : "1",
				isFolder : true,
				children : null
			});
			return preguntas;
		}

	},
	'showInformation' : function() {
		var information = arguments[0];
		// for( var i = 0; i < arguments.length; i++) {
		// information.push(arguments[i]);
		// }
		showInformationIntoView(information);
	}
};