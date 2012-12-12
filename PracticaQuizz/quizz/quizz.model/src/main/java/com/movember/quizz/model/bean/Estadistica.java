package com.movember.quizz.model.bean;

import java.util.List;

public class Estadistica {
	private String encuesta;
	private List<PreguntaEstadistica> preguntas;
	private Integer idEncuesta;
	public String getEncuesta() {
		return encuesta;
	}
	public void setEncuesta(String pEncuesta) {
		encuesta = pEncuesta;
	}
	public List<PreguntaEstadistica> getPreguntas() {
		return preguntas;
	}
	public void setPreguntas(List<PreguntaEstadistica> preguntas) {
		this.preguntas = preguntas;
	}
	public Integer getIdEncuesta() {
		return idEncuesta;
	}
	public void setIdEncuesta(Integer idEncuesta) {
		this.idEncuesta = idEncuesta;
	}
}
