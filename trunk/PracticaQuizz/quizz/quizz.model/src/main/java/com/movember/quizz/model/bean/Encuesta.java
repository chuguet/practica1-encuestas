package com.movember.quizz.model.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.annotations.Entity;

@Entity
public class Encuesta extends AbstractBean {
	private String nombre;
	private Date fecha_inicio;
	private Date fecha_fin;
	private List<Pregunta> preguntas;

	public Encuesta() {
		this.preguntas = new ArrayList<Pregunta>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public List<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
}
