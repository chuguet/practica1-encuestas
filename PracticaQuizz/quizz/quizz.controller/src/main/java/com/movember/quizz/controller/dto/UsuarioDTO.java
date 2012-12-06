package com.movember.quizz.controller.dto;

import com.movember.quizz.model.bean.Usuario;
import com.movember.quizz.model.exception.AppException;

public class UsuarioDTO extends AbstractDTO {
	private String nombre;
	private String apellidos;
	private String email;
	private String usuario;
	private String pwd;
	private Integer admin;

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

	@Override
	public void toRest(Object object) throws AppException {
		Usuario usuario = (Usuario) object;
		this.setId(usuario.getId());
		this.nombre = usuario.getNombre();
		this.apellidos = usuario.getApellidos();
		this.email = usuario.getEmail();
		this.usuario = usuario.getUsuario();
		this.pwd = usuario.getPwd();
		this.admin = usuario.getAdmin();
	}

	@Override
	public void toBusiness(Object object) throws AppException {
		Usuario usuario = (Usuario) object;
		usuario.setId(this.getId());
		usuario.setNombre(this.nombre);
		usuario.setApellidos(this.apellidos);
		usuario.setEmail(this.email);
		usuario.setUsuario(this.usuario);
		usuario.setPwd(this.pwd);
		usuario.setAdmin(this.admin);
	}
}
