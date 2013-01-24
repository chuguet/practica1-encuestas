var estadistica = {
	'mostrarEstadistica' : function(registro) {
		// Introduzco nombre de la encuesta en un span del jsp
		var nombreEncuesta = $('legend.quizzText').text() + registro.encuesta;
		$('legend.quizzText').text(nombreEncuesta);
		var identificados = $('p#identificados');
		var numeroRespondidas = 0;
		var numeroIdentificados = 0;
		var numeroNoIdentificados = 0;
		var numeroTotalIdentificados = 0;
		var numeroTotalNoIdentificados = 0;
		// Meto las preguntas
		for( var i = 0; i < registro.preguntas.length; i++) {
			var pregunta = registro.preguntas[i];
			var nombrePregunta = $("<span class='questionText'>" + pregunta.pregunta + "</span>");
			$('#estadistica').append(nombrePregunta);
			// Meto las respuestas
			var lista = $('<ul class="chart" id="pregunta_' + pregunta.pregunta + '">');
			$('#estadistica').append(lista);

			var count = 0;
			for( var j = 0; j < pregunta.respuestas.length; j++) {
				numeroIdentificados = pregunta.respuestas[j].vecesIdentificado;
				numeroNoIdentificados = pregunta.respuestas[j].vecesNoIdentificado;
				numeroRespondidas = pregunta.respuestas[j].vecesIdentificado + pregunta.respuestas[j].vecesNoIdentificado;
				numeroTotalIdentificados += numeroIdentificados;
				numeroTotalNoIdentificados += numeroNoIdentificados;
				var nombreRespuesta = $('<li title="Identificados: ' + numeroIdentificados + ' - No Identificados: ' + numeroNoIdentificados + '" count="' + numeroRespondidas + '" class="red"><span class="graphText">' + pregunta.respuestas[j].respuesta + '</span><span class="bar"></span><span class="percent"></span></li>');
				count += numeroRespondidas;
				lista.append(nombreRespuesta);
			}
			if (identificados && i == 0) {
				identificados.append(" - Usuarios identificados: " + numeroTotalIdentificados + "<br/> - Usuarios no identificados: " + numeroTotalNoIdentificados + "<br/>");
			}
			lista.find("li").each(function() {
				var result = (this.getAttribute("count") / count) * 100;
				this.setAttribute("pc", result);
			});
		}
		this.visualizeGraph();
		$("#btnVolver").button().click(function() {
			generic.getList('rellenarEncuesta', rellenarEncuesta.getUser());
		});
	},
	'visualizeGraph' : function() {
		$('.chart li').each(function() {
			var pc = $(this).attr('pc');
			pc = pc > 100 ? 100 : pc;
			pc = estadistica.rounding(pc);
			if (pc + "" == "NaN") {
				pc = "0";
				$(this).attr('pc', pc);
			}
			$(this).children('.percent').html(pc + '%');
			var ww = $(this).width();
			var len = parseInt(ww, 10) * parseInt(pc, 10) / 100;
			$(this).children('.bar').animate({
				'width' : len + 'px'
			}, 1500);
		});
	},
	'rounding' : function(numero) {
		var original = parseFloat(numero);
		var result = Math.round(original * 100) / 100;
		return result;
	}
};