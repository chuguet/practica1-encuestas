package com.movember.quizz.model.bean;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "respuesta")
public class Respuesta implements IModelTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "ID")
	private Long id;
	@Column(length = 100, name = "RESPUESTA")
	private String respuesta;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIOS_RESPUESTA")
	private Collection<Usuario> usuariosRespuesta;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIOS_ANONIMOS_RESPUESTA")
	private Collection<UsuarioAnonimo> usuariosAnonimosRespuesta;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "PREGUNTA_RESPUESTA")
	private Pregunta preguntaRespuesta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public Pregunta getPreguntaRespuesta() {
		return preguntaRespuesta;
	}

	public void setPreguntaRespuesta(Pregunta preguntaRespuesta) {
		this.preguntaRespuesta = preguntaRespuesta;
	}

	public Collection<UsuarioAnonimo> getUsuariosAnonimosRespuesta() {
		return usuariosAnonimosRespuesta;
	}

	public void setUsuariosAnonimosRespuesta(Collection<UsuarioAnonimo> usuariosAnonimosRespuesta) {
		this.usuariosAnonimosRespuesta = usuariosAnonimosRespuesta;
	}

	public Collection<Usuario> getUsuariosRespuesta() {
		return usuariosRespuesta;
	}

	public void setUsuariosRespuesta(Collection<Usuario> usuariosRespuesta) {
		this.usuariosRespuesta = usuariosRespuesta;
	}

}