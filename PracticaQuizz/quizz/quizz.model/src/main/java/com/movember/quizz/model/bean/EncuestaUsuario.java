package com.movember.quizz.model.bean;

public class EncuestaUsuario implements IModelTable {
	private Long id_encuesta;
	private Long id_usuario;
	private String ip_dispositivo;

	public Long getId_encuesta() {
		return id_encuesta;
	}

	public void setId_encuesta(Long id_encuesta) {
		this.id_encuesta = id_encuesta;
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getIp_dispositivo() {
		return ip_dispositivo;
	}

	public void setIp_dispositivo(String ip_dispositivo) {
		this.ip_dispositivo = ip_dispositivo;
	}

}
