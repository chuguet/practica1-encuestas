var estadistica = {
	'mostrarEstadistica' : function(registro) {
		// Introduzco nombre de la encuesta en un span del jsp
		$('#estadistica #encuesta').text(registro.encuesta);
		// Meto las preguntas
		for ( var i = 0; i < registro.preguntas.length; i++) {
			var nombrePregunta = $("<p>" + registro.preguntas[i].pregunta
					+ "</p>");
			$('#estadistica #encuesta').append(nombrePregunta);
			// Meto las respuestas
			for ( var j = 0; j < registro.preguntas[i].respuestas.length; j++) {
				var nombreRespuesta = $("<p>"
						+ registro.preguntas[i].respuestas[j].respuesta + "</p>");
				var vecesContestada = $("<p>"
						+ registro.preguntas[i].respuestas[j].vecesContestada
						+ "</p>");
				$('#estadistica #encuesta').append(nombreRespuesta);
				$('#estadistica #encuesta').append(vecesContestada);
			}
		}
	}
};