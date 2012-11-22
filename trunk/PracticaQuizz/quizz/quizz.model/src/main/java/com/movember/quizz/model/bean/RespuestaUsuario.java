package com.movember.quizz.model.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "respuesta_usuario")
public class RespuestaUsuario implements IModelTable {
	@Id
	@GeneratedValue
	private Long id;
	private Long id_respuesta;
	private Long id_usuario;

	public Long getId_respuesta() {
		return id_respuesta;
	}

	public void setId_respuesta(Long id_respuesta) {
		this.id_respuesta = id_respuesta;
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
