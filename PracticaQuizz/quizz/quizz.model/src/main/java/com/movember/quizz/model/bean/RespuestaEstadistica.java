package com.movember.quizz.model.bean;

public class RespuestaEstadistica {
	private String respuesta;
	private int vecesContestada;
	private Integer idPregunta;
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public int getVecesContestada() {
		return vecesContestada;
	}
	public void setVecesContestada(int vecesContestada) {
		this.vecesContestada = vecesContestada;
	}
	public Integer getIdPregunta() {
		return idPregunta;
	}
	public void setIdPregunta(Integer idPregunta) {
		this.idPregunta = idPregunta;
	}
}
