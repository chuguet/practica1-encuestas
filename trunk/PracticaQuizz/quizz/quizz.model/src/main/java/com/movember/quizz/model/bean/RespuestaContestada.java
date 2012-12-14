package com.movember.quizz.model.bean;


public class RespuestaContestada extends AbstractBean {
	private Integer id_respuesta;
	private Integer id_encuesta_contestada;

	public Integer getId_respuesta() {
		return id_respuesta;
	}

	public void setId_respuesta(Integer id_respuesta) {
		this.id_respuesta = id_respuesta;
	}

	public Integer getId_encuesta_contestada() {
		return id_encuesta_contestada;
	}

	public void setId_encuesta_contestada(Integer id_encuesta_contestada) {
		this.id_encuesta_contestada = id_encuesta_contestada;
	}

}