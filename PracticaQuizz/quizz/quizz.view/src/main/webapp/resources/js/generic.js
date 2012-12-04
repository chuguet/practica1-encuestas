var generic = {
	"uri" : "http://localhost:8080/com.movember.quizz.view/",
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
	'showInformation' : function() {
		var information = arguments[0];
		showInformationIntoView(information);
	}
};