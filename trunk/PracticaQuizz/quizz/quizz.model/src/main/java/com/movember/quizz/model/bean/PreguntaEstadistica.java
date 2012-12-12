package com.movember.quizz.model.bean;

import java.util.List;

public class PreguntaEstadistica {

	private String pregunta;
	private Integer idEncuesta;
	private List<RespuestaEstadistica> respuestas;

	public Integer getIdEncuesta() {
		return idEncuesta;
	}

	public String getPregunta() {
		return pregunta;
	}

	public List<RespuestaEstadistica> getRespuestas() {
		return respuestas;
	}

	public void setIdEncuesta(Integer idEncuesta) {
		this.idEncuesta = idEncuesta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public void setRespuestas(List<RespuestaEstadistica> respuestas) {
		this.respuestas = respuestas;
	}
}
