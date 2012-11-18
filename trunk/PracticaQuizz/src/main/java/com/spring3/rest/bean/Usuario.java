package com.spring3.rest.bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellidos")
	private String apellidos;
	@Column(name = "email")
	private String email;
	@Column(name = "usuario")
	private String usuario;
	@Column(name = "pwd")
	private String pwd;
	@Column(name = "admin")
	private Integer admin;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	@Column(name = "nombre")
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "nombre")
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

	@Override
	public boolean equals(Object obj) {
		return true;
	}
}