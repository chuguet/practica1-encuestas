package com.movember.quizz.controller.dto;

import java.util.ArrayList;
import java.util.List;
import com.movember.quizz.model.bean.EncuestaContestada;
import com.movember.quizz.model.exception.AppException;

public class EncuestaContestadaDTO extends AbstractDTO {
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

	public EncuestaContestadaDTO() {
		idRespuestasContestadas = new ArrayList<Integer>();
	}

	@Override
	public void toRest(Object object) throws AppException {
		EncuestaContestada encuestaContestada = (EncuestaContestada) object;
		this.id_encuesta = encuestaContestada.getId_encuesta();
		this.id_usuario = encuestaContestada.getId_usuario();
		this.ip_usuario = encuestaContestada.getIp_usuario();
		this.idRespuestasContestadas = encuestaContestada.getIdRespuestasContestadas();
	}

	@Override
	public void toBusiness(Object object) throws AppException {
		EncuestaContestada encuestaContestada = (EncuestaContestada) object;
		encuestaContestada.setId_encuesta(this.id_encuesta);
		encuestaContestada.setId_usuario(this.id_usuario);
		encuestaContestada.setIp_usuario(this.ip_usuario);
		encuestaContestada.setIdRespuestasContestadas(this.idRespuestasContestadas);
	}
}
