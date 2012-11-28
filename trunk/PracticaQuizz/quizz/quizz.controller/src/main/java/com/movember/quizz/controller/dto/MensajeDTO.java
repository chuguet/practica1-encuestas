package com.movember.quizz.controller.dto;

public class MensajeDTO {
	private String mensaje;
	private Boolean correcto;

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Boolean getCorrecto() {
		return correcto;
	}

	public void setCorrecto(Boolean correcto) {
		this.correcto = correcto;
	}

	public MensajeDTO() {
		this.correcto = true;
	}
}