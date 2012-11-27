package com.movember.quizz.model.bean;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class Usuario implements IModelTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "APELLIDOS")
	private String apellidos;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "USUARIO")
	private String usuario;
	@Column(name = "PWD")
	private String pwd;
	@Column(name = "ADMIN")
	private Integer admin;

	@ManyToMany(cascade = CascadeType.ALL)
	private Collection<Encuesta> encuestasUsuario;
	@ManyToMany(cascade = CascadeType.ALL)
	private Collection<Respuesta> respuestasUsuario;

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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getAdmin() {
		return admin;
	}

	public void setAdmin(Integer admin) {
		this.admin = admin;
	}

	public Usuario() {
	}

	public Usuario(String nombre, String apellidos, String email, String usuario, String pwd, Integer admin) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.usuario = usuario;
		this.pwd = pwd;
		this.admin = admin;
	}

	public Collection<Encuesta> getEncuestasUsuario() {
		return encuestasUsuario;
	}

	public void setEncuestasUsuario(Collection<Encuesta> encuestasUsuario) {
		this.encuestasUsuario = encuestasUsuario;
	}

	public Collection<Respuesta> getRespuestasUsuario() {
		return respuestasUsuario;
	}

	public void setRespuestasUsuario(Collection<Respuesta> respuestasUsuario) {
		this.respuestasUsuario = respuestasUsuario;
	}

}