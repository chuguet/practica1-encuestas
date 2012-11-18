package com.spring3.rest.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="usuario")
public class Usuario {
	private Integer id;
	private String nombre;
	private String apellidos;
	private String email;
	private String usuario;
	private String pwd;
	
	public Usuario() {}
	
	public Usuario(String nombre, String apellidos, String email, String usuario, String pwd) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.usuario = usuario;
		this.pwd = pwd;
	}

	@Override
	public boolean equals(Object obj) {
		return true;
	}
}
