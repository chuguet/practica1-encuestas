package com.movember.quizz.controller.dto;

import com.movember.quizz.model.bean.ParametrosEncuesta;
import com.movember.quizz.model.exception.AppException;

public class ParametrosEncuestaDTO extends AbstractDTO {
	private String ip_usuario;
	private String id_usuario;

	public String getIp_usuario() {
		return ip_usuario;
	}

	public void setIp_usuario(String ip_usuario) {
		this.ip_usuario = ip_usuario;
	}

	public String getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}

	@Override
	public void toRest(Object object) throws AppException {
		ParametrosEncuesta parametrosEncuesta = (ParametrosEncuesta) object;
		this.ip_usuario = parametrosEncuesta.getIp_usuario();
		if (parametrosEncuesta.getId_usuario() != null) {
			this.id_usuario = parametrosEncuesta.getId_usuario().toString();
		}
	}

	@Override
	public void toBusiness(Object object) throws AppException {
		ParametrosEncuesta parametrosEncuesta = (ParametrosEncuesta) object;

		if (this.id_usuario != null && this.id_usuario.length() > 0) {
			parametrosEncuesta.setId_usuario(Integer.parseInt(this.id_usuario));
		}
		else {
			parametrosEncuesta.setIp_usuario(this.ip_usuario);
		}
	}
}