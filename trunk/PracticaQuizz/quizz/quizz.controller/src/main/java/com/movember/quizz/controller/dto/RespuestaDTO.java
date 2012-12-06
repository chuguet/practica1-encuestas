package com.movember.quizz.controller.dto;

import com.movember.quizz.model.bean.Respuesta;
import com.movember.quizz.model.exception.AppException;

public class RespuestaDTO extends AbstractDTO {
	private String title;
	private String key;
	private boolean isFolder;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setIsFolder(boolean isFolder) {
		this.isFolder = isFolder;
	}

	public boolean getIsFolder() {
		return isFolder;
	}

	@Override
	public void toRest(Object object) throws AppException {
		Respuesta respuesta = (Respuesta) object;
		if (respuesta.getId() != null) {
			this.key = "r" + respuesta.getId().toString();
			this.setId(respuesta.getId());
		}
		this.title = respuesta.getRespuesta();
		this.isFolder = false;
	}

	@Override
	public void toBusiness(Object object) throws AppException {
		Respuesta respuesta = (Respuesta) object;
		if (this.key.indexOf('r') != -1) {
			respuesta.setId(Integer.parseInt(this.key.replace("r", "")));
		}
		respuesta.setRespuesta(this.title);
	}
}
