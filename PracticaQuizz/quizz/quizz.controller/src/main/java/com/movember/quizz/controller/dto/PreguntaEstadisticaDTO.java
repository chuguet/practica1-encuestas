package com.movember.quizz.controller.dto;

import java.util.ArrayList;
import java.util.List;

import com.movember.quizz.model.bean.PreguntaEstadistica;
import com.movember.quizz.model.bean.RespuestaEstadistica;
import com.movember.quizz.model.exception.AppException;

public class PreguntaEstadisticaDTO extends AbstractDTO {

	private String pregunta;
	private Integer idEncuesta;
	private List<RespuestaEstadisticaDTO> respuestas;

	public Integer getIdEncuesta() {
		return idEncuesta;
	}

	public String getPregunta() {
		return pregunta;
	}

	public List<RespuestaEstadisticaDTO> getRespuestas() {
		return respuestas;
	}

	public void setIdEncuesta(Integer idEncuesta) {
		this.idEncuesta = idEncuesta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public void setRespuestas(List<RespuestaEstadisticaDTO> respuestas) {
		this.respuestas = respuestas;
	}

	@Override
	public void toRest(Object object) throws AppException {
		PreguntaEstadistica pregunta = (PreguntaEstadistica) object;
		// this.setId(estadistica.getId());
		this.setPregunta(pregunta.getPregunta());
		this.setIdEncuesta(pregunta.getIdEncuesta());

		if (pregunta.getRespuestas() != null
				&& pregunta.getRespuestas().size() > 0) {
			RespuestaEstadisticaDTO respuestaEstadisticaDTO;
			for (RespuestaEstadistica respuesta : pregunta.getRespuestas()) {
				respuestaEstadisticaDTO = new RespuestaEstadisticaDTO();
				respuestaEstadisticaDTO.toRest(respuesta);
				this.addRespuestaDTO(respuestaEstadisticaDTO);
			}
		}
	}

	private void addRespuestaDTO(RespuestaEstadisticaDTO respuestaEstadisticaDTO) {
		if (this.getRespuestas() == null) {
			this.respuestas = new ArrayList<RespuestaEstadisticaDTO>();
		}
		respuestas.add(respuestaEstadisticaDTO);
	}

	@Override
	public void toBusiness(Object object) throws AppException {
	}
}
