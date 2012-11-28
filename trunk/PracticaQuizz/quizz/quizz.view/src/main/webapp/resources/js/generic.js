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
				generic.get(entity, item);
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
						callback.apply(this, response);
					}
				}
				else {
					jAlert(response.mensaje, 'Operación correcta');
					if (response.correcto) {
						if (callback) {
							callback.apply(this, response);
						}
					}
				}
			},
			error : function(e) {
				alert(e);
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
			'id' : id,
			'nombre' : $("#nombre").val(),
			'fecha_inicio' : fecha_inicio,
			'fecha_fin' : fecha_fin,
			'preguntas' : generic.getQuestions()
		};
		var entity = (id != null) ? 'encuesta/' + id : 'encuesta';
		generic.post(entity, data, function() {
			generic.getList('encuesta');
		});
	},
	'generateQuestionsTree' : function(selector) {
		$(selector).dynatree({
			initAjax : {
			/* url: "sample-data3.json" */
			},
			onLazyRead : function(node) {
				// Mockup a slow reqeuest ...
				node.appendAjax({
					/* url: "sample-data2.json", */
					debugLazyDelay : 750
				// don't do thi in production code
				});
			},
			dnd : {
				preventVoidMoves : true, // Prevent dropping nodes 'before
				// self', etc.
				onDragStart : function(node) {
					/**
					 * This function MUST be defined to enable dragging for the
					 * tree. Return false to cancel dragging of node.
					 */
					return true;
				},
				onDragEnter : function(node, sourceNode) {
					/**
					 * sourceNode may be null for non-dynatree droppables.
					 * Return false to disallow dropping on node. In this case
					 * onDragOver and onDragLeave are not called. Return 'over',
					 * 'before, or 'after' to force a hitMode. Return ['before',
					 * 'after'] to restrict available hitModes. Any other return
					 * value will calc the hitMode from the cursor position.
					 */
					// Prevent dropping a parent below another parent (only sort
					// nodes under the same parent)
					if (node.parent !== sourceNode.parent) {
						return false;
					}
					// Don't allow dropping *over* a node (would create a child)
					return [
							"before", "after"
					];
				},
				onDrop : function(node, sourceNode, hitMode, ui, draggable) {
					/**
					 * This function MUST be defined to enable dropping of items
					 * on the tree.
					 */
					sourceNode.move(node, hitMode);
				}
			}
		});
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
						'texto' : respArray[j].title
					};
					respuestas.push(respuesta);
				}

				var pregunta = {
					'texto' : p.title,
					'respuestasPregunta' : respuestas
				};
				preguntas.push(pregunta);
			}
			return preguntas;
		}
		// else {
		// return [
		// {
		// 'texto' : "Pregunta1"
		// }
		// ];
		// }

	},
	'showInformation' : function() {
		var information = arguments;
		$("#lista").setGridParam({
			data : information
		}).trigger("reloadGrid");
	}
};