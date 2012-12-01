package com.movember.quizz.model.bean;

import javax.persistence.Entity;

@Entity
public class Respuesta extends AbstractBean {
	private String respuesta;

	private Integer id_pregunta;

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public void setId_pregunta(Integer id_pregunta) {
		this.id_pregunta = id_pregunta;
	}

	public Integer getId_pregunta() {
		return id_pregunta;
	}

	@Override
	public boolean equals(Object otra) {
		Respuesta respuesta = (Respuesta) otra;
		return this.getId().equals(respuesta.getId());
	}
}