package com.movember.quizz.model.bean;

import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ENCUESTA")
public class Encuesta implements IModelTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "NOMBRE", length = 100)
	private String nombre;
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_INICIO")
	private Date fecha_inicio;
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_FIN")
	private Date fecha_fin;

	@OneToMany(cascade = CascadeType.ALL)
	private Collection<Pregunta> preguntas;
	@ManyToMany(cascade = CascadeType.ALL)
	private Collection<Usuario> usuarios;

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

	public Collection<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(Collection<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public Collection<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Collection<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
