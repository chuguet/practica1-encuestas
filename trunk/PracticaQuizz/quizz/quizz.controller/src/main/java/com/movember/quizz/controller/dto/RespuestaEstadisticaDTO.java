package com.movember.quizz.controller.dto;

import com.movember.quizz.model.bean.RespuestaEstadistica;
import com.movember.quizz.model.exception.AppException;

public class RespuestaEstadisticaDTO extends AbstractDTO{
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

	@Override
	public void toRest(Object object) throws AppException {
		RespuestaEstadistica respuestaEstadistica = (RespuestaEstadistica)object;
		this.setIdPregunta(respuestaEstadistica.getIdPregunta());
		this.setRespuesta(respuestaEstadistica.getRespuesta());
		this.setVecesContestada(respuestaEstadistica.getVecesContestada());
	}

	@Override
	public void toBusiness(Object object) throws AppException {
	}
}
