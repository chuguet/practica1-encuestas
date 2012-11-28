package com.movember.quizz.controller.dto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.movember.quizz.model.bean.Encuesta;
import com.movember.quizz.model.bean.Pregunta;
import com.movember.quizz.model.bean.Usuario;

public class EncuestaDTO extends AbstractDTO {
	private Long id;
	private String nombre;
	private String fecha_inicio;
	private String fecha_fin;

	private List<Pregunta> preguntas = new ArrayList<Pregunta>();
	private List<Usuario> usuariosEncuesta = new ArrayList<Usuario>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public String getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public List<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public List<Usuario> getUsuariosEncuesta() {
		return usuariosEncuesta;
	}

	public void setUsuariosEncuesta(List<Usuario> usuariosEncuesta) {
		this.usuariosEncuesta = usuariosEncuesta;
	}

	@Override
	public void toRest(Object object) {
		Encuesta encuesta = (Encuesta) object;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		this.id = encuesta.getId();
		this.nombre = encuesta.getNombre();
		this.fecha_inicio = sdf.format(encuesta.getFecha_inicio());
		this.fecha_fin = sdf.format(encuesta.getFecha_fin());
	}

	@Override
	public void toBusiness(Object object) {
		Encuesta encuesta = (Encuesta) object;
		encuesta.setId(this.id);
		encuesta.setNombre(this.nombre);
		encuesta.setFecha_fin(new Date());
		encuesta.setFecha_inicio(new Date());
	}
}
