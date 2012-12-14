package com.movember.quizz.model.bean;

import java.util.ArrayList;
import java.util.List;

public class EncuestaContestada extends AbstractBean {
	private Integer id_encuesta;
	private Integer id_usuario;
	private String ip_usuario;
	private List<Integer> idRespuestasContestadas;

	public void setId_encuesta(Integer id_encuesta) {
		this.id_encuesta = id_encuesta;
	}

	public Integer getId_encuesta() {
		return id_encuesta;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getIp_usuario() {
		return ip_usuario;
	}

	public void setIp_usuario(String ip_usuario) {
		this.ip_usuario = ip_usuario;
	}

	public List<Integer> getIdRespuestasContestadas() {
		return idRespuestasContestadas;
	}

	public void setIdRespuestasContestadas(List<Integer> idRespuestasContestadas) {
		this.idRespuestasContestadas = idRespuestasContestadas;
	}

	public EncuestaContestada() {
		idRespuestasContestadas = new ArrayList<Integer>();
	}
}