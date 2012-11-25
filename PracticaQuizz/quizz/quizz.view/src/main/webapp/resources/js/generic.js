var generic = {
	"uri" : "http://localhost:8080/com.movember.quizz.view/rest/",
	"get" : function(action) {
		this.execute('GET', action, null);
	},
	"post" : function(action, params) {
		this.execute('POST', action, params);
	},
	"put" : function(action, params) {
		this.execute('PUT', action, params);
	},
	"delete" : function(action) {
		this.execute('DELETE', action, null);
	},
	"execute" : function($method, action, data) {
		$.ajax({
			type : $method,
			url : this.uri + action,
			data : data,
			success : function(response) {
				$('#content').html(response);
				/*
				 * $('#info').html(response); $('#name').val('');
				 * $('#education').val('');
				 */
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
		/*
		 * xmlhttp = new XMLHttpRequest(); xmlhttp.open($method, this.uri +
		 * $url, true); xmlhttp.send(null);
		 */
	},
	'getParamsUsuario' : function() {
		var data = {
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
		var data = {
			'nombre' : $("#nombre").val(),
			'fecha_inicio' : $("#fecha_inicio").val(),
			'fecha_fin' : $("#fecha_fin").val()
		}
		return data;
	}
};