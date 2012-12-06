package com.movember.quizz.controller.dto;

import java.util.ArrayList;
import java.util.List;
import com.movember.quizz.model.bean.Pregunta;
import com.movember.quizz.model.bean.Respuesta;
import com.movember.quizz.model.exception.AppException;

public class PreguntaDTO extends AbstractDTO {
	private String title;
	private boolean isFolder;
	private String key;
	private List<RespuestaDTO> children = new ArrayList<RespuestaDTO>();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean getIsFolder() {
		return isFolder;
	}

	public void setIsFolder(boolean isFolder) {
		this.isFolder = isFolder;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<RespuestaDTO> getChildren() {
		return children;
	}

	public void setChildren(List<RespuestaDTO> children) {
		this.children = children;
	}

	@Override
	public void toRest(Object object) throws AppException {
		Pregunta pregunta = (Pregunta) object;
		if (pregunta.getId() != null) {
			this.key = "p" + pregunta.getId().toString();
			this.setId(pregunta.getId());
		}
		this.title = pregunta.getPregunta();
		this.isFolder = true;
		if (pregunta.getRespuestas() != null && pregunta.getRespuestas().size() > 0) {
			for (Respuesta respuesta : pregunta.getRespuestas()) {
				RespuestaDTO respuestaDTO = new RespuestaDTO();
				respuestaDTO.toRest(respuesta);
				this.children.add(respuestaDTO);
			}
		}
	}

	@Override
	public void toBusiness(Object object) throws AppException {
		Pregunta pregunta = (Pregunta) object;
		if (this.key.indexOf('p') != -1) {
			pregunta.setId(Integer.parseInt(this.key.replace("p", "")));
		}
		pregunta.setPregunta(this.title);

		if (this.children != null && this.children.size() > 0) {
			for (RespuestaDTO respuestaDTO : this.children) {
				Respuesta respuesta = new Respuesta();
				respuesta.setId_pregunta(pregunta.getId());
				respuestaDTO.toBusiness(respuesta);
				pregunta.getRespuestas().add(respuesta);
			}
		}
	}
}
