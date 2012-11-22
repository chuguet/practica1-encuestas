package com.movember.quizz.model.bean;

public class RespuestaUsuario implements IModelTable {
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
}
