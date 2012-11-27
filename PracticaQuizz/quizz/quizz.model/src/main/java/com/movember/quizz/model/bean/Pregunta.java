package com.movember.quizz.model.bean;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PREGUNTA")
public class Pregunta implements IModelTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 100, name = "PREGUNTA")
	private String pregunta;

	@OneToOne(cascade = CascadeType.ALL)
	private Encuesta encuestaPregunta;
	@OneToMany(cascade = CascadeType.ALL)
	private Collection<Respuesta> respuestasPregunta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public Collection<Respuesta> getRespuestasPregunta() {
		return respuestasPregunta;
	}

	public void setRespuestasPregunta(Collection<Respuesta> respuestasPregunta) {
		this.respuestasPregunta = respuestasPregunta;
	}

	public Encuesta getEncuestaPregunta() {
		return encuestaPregunta;
	}

	public void setEncuestaPregunta(Encuesta encuestaPregunta) {
		this.encuestaPregunta = encuestaPregunta;
	}

}
