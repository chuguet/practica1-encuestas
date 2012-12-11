package com.movember.quizz.controller.dto;

import com.movember.quizz.model.bean.ParametrosEncuesta;
import com.movember.quizz.model.exception.AppException;

public class ParametrosEncuestaDTO extends AbstractDTO {
	private String ip_usuario;
	private Integer id_usuario;

	public String getIp() {
		return ip_usuario;
	}

	public void setIp_usuario(String ip_usuario) {
		this.ip_usuario = ip_usuario;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	@Override
	public void toRest(Object object) throws AppException {
		ParametrosEncuesta parametrosEncuesta = (ParametrosEncuesta) object;
		this.setId(parametrosEncuesta.getId());
		this.ip_usuario = parametrosEncuesta.getIp_usuario();
		this.id_usuario = parametrosEncuesta.getId_usuario();
	}

	@Override
	public void toBusiness(Object object) throws AppException {
		ParametrosEncuesta parametrosEncuesta = (ParametrosEncuesta) object;
		parametrosEncuesta.setIp_usuario(this.ip_usuario);
		parametrosEncuesta.setId(this.getId());
		parametrosEncuesta.setId_usuario(this.id_usuario);
	}
}