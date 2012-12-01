package com.movember.quizz.controller.dto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.movember.quizz.model.bean.Encuesta;
import com.movember.quizz.model.bean.Pregunta;

public class EncuestaDTO extends AbstractDTO {
	private String nombre;
	private String fecha_inicio;
	private String fecha_fin;
	private List<PreguntaDTO> preguntasDTO;

	public EncuestaDTO() {
		preguntasDTO = new ArrayList<PreguntaDTO>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public String getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public List<PreguntaDTO> getPreguntasDTO() {
		return preguntasDTO;
	}

	public void setPreguntasDTO(List<PreguntaDTO> preguntasDTO) {
		this.preguntasDTO = preguntasDTO;
	}

	@Override
	public void toRest(Object object) {
		Encuesta encuesta = (Encuesta) object;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		this.setId(encuesta.getId());
		this.nombre = encuesta.getNombre();
		this.fecha_inicio = sdf.format(encuesta.getFecha_inicio());
		this.fecha_fin = sdf.format(encuesta.getFecha_fin());

		if (encuesta.getPreguntas() != null && encuesta.getPreguntas().size() > 0) {
			for (Pregunta pregunta : encuesta.getPreguntas()) {
				PreguntaDTO preguntaDTO = new PreguntaDTO();
				preguntaDTO.toRest(pregunta);
				this.preguntasDTO.add(preguntaDTO);
			}
		}
	}

	@Override
	public void toBusiness(Object object) {
		Encuesta encuesta = (Encuesta) object;
		encuesta.setId(this.getId());
		encuesta.setNombre(this.nombre);
		encuesta.setFecha_fin(new Date());
		encuesta.setFecha_inicio(new Date());

		if (this.preguntasDTO != null && this.preguntasDTO.size() > 0) {
			for (PreguntaDTO preguntaDTO : this.preguntasDTO) {
				Pregunta pregunta = new Pregunta();
				pregunta.setId_encuesta(this.getId());
				preguntaDTO.toBusiness(pregunta);
				encuesta.getPreguntas().add(pregunta);
			}
		}
	}
}
