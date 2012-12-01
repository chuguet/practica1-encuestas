package com.movember.quizz.model.bean;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;

@Entity
public class Pregunta extends AbstractBean {
	private String pregunta;
	private Integer id_encuesta;
	private List<Respuesta> respuestas;

	public Pregunta() {
		this.respuestas = new ArrayList<Respuesta>();
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public void setId_encuesta(Integer id_encuesta) {
		this.id_encuesta = id_encuesta;
	}

	public Integer getId_encuesta() {
		return id_encuesta;
	}

	public List<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

	@Override
	public boolean equals(Object otra) {
		Pregunta pregunta = (Pregunta) otra;
		return this.getId().equals(pregunta.getId());
	}
}