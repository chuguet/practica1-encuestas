var estadistica = {
	'mostrarEstadistica' : function(registro) {
		// Introduzco nombre de la encuesta en un span del jsp
		$('#estadistica #encuesta').text(registro.encuesta);

		for ( var i = 0; i < registro.preguntas.length; i++) {
			grafica(registro.preguntas[i].pregunta, registro.preguntas[i].respuestas);
		}
		// // Meto las preguntas
		// for ( var i = 0; i < registro.preguntas.length; i++) {
		// var nombrePregunta = $("<p>" + registro.preguntas[i].pregunta
		// + "</p>");
		// $('#estadistica #encuesta').append(nombrePregunta);
		// // Meto las respuestas
		// for ( var j = 0; j < registro.preguntas[i].respuestas.length; j++) {
		// var nombreRespuesta = $("<p>"
		// + registro.preguntas[i].respuestas[j].respuesta
		// + "</p>");
		// var vecesContestada = $("<p>"
		// + registro.preguntas[i].respuestas[j].vecesContestada
		// + "</p>");
		// $('#estadistica #encuesta').append(nombreRespuesta);
		// $('#estadistica #encuesta').append(vecesContestada);
		// }
		// }
	}
};

function grafica(pregunta, respuestas) {
	var data = new Array(respuestas.length);
	var colors = new Array(respuestas.length);
	for ( var j = 0; j < respuestas.length; j++) {
		var field = [ respuestas[j].respuesta, respuestas[j].vecesContestada ];
		data[j] = field;
		colors[j] = dame_color_aleatorio();
	}
	var myChart = new JSChart('graph', 'bar');
	myChart.setDataArray(data);
	myChart.colorizeBars(colors);
	myChart.setTitle(pregunta);
	myChart.setTitleColor('#8E8E8E');
	myChart.setAxisNameX('Respuestas');
	myChart.setAxisNameY('Usuarios');
	myChart.setAxisColor('#C4C4C4');
	myChart.setAxisNameFontSize(16);
	myChart.setAxisNameColor('#999');
	myChart.setAxisValuesColor('#7E7E7E');
	myChart.setBarValuesColor('#7E7E7E');
	myChart.setAxisPaddingTop(60);
	myChart.setAxisPaddingRight(140);
	myChart.setAxisPaddingLeft(150);
	myChart.setAxisPaddingBottom(40);
	myChart.setTextPaddingLeft(105);
	myChart.setTitleFontSize(11);
	myChart.setBarBorderWidth(1);
	myChart.setBarBorderColor('#C4C4C4');
	myChart.setBarSpacingRatio(50);
	myChart.setGrid(false);
	myChart.setSize(616, 321);
	// myChart.setBackgroundImage('chart_bg.jpg');
	myChart.draw();
}

function dame_color_aleatorio() {
	hexadecimal = new Array("0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
			"A", "B", "C", "D", "E", "F");
	color_aleatorio = "#";
	for ( var i = 0; i < 6; i++) {
		posarray = aleatorio(0, hexadecimal.length);
		color_aleatorio += hexadecimal[posarray];
	}
	return color_aleatorio;
}

function aleatorio(inferior, superior) {
	numPosibilidades = superior - inferior;
	aleat = Math.random() * numPosibilidades;
	aleat = Math.floor(aleat);
	return parseInt(inferior) + aleat;
}