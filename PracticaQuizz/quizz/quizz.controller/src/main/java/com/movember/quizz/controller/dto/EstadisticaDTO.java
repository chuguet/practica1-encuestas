package com.movember.quizz.controller.dto;

import java.util.ArrayList;
import java.util.List;

import com.movember.quizz.model.bean.Estadistica;
import com.movember.quizz.model.bean.PreguntaEstadistica;
import com.movember.quizz.model.exception.AppException;

public class EstadisticaDTO extends AbstractDTO {

	private String encuesta;
	private List<PreguntaEstadisticaDTO> preguntas;

	public String getEncuesta() {
		return encuesta;
	}

	public void setEncuesta(String pEncuesta) {
		encuesta = pEncuesta;
	}

	public List<PreguntaEstadisticaDTO> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<PreguntaEstadisticaDTO> preguntas) {
		this.preguntas = preguntas;
	}

	@Override
	public void toRest(Object object) throws AppException {
		Estadistica estadistica = (Estadistica) object;
		// this.setId(estadistica.getId());
		this.setEncuesta(estadistica.getEncuesta());
		this.setId(estadistica.getIdEncuesta());
		if (estadistica.getPreguntas() != null
				&& estadistica.getPreguntas().size() > 0) {
			PreguntaEstadisticaDTO preguntaEstadisticaDTO;
			for (PreguntaEstadistica pregunta : estadistica.getPreguntas()) {
				preguntaEstadisticaDTO = new PreguntaEstadisticaDTO();
				preguntaEstadisticaDTO.toRest(pregunta);
				this.addPreguntaDTO(preguntaEstadisticaDTO);
			}
		}
	}

	private void addPreguntaDTO(PreguntaEstadisticaDTO preguntaEstadisticaDTO) {
		if (this.getPreguntas() == null) {
			this.preguntas = new ArrayList<PreguntaEstadisticaDTO>();
		}
		preguntas.add(preguntaEstadisticaDTO);
	}

	@Override
	public void toBusiness(Object object) throws AppException {
	}

}
