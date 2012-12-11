package com.movember.quizz.model.bean;

import javax.persistence.Entity;

@Entity
public class ParametrosEncuesta extends AbstractBean {
	private String ip_usuario;
	private Integer id_usuario;

	public String getIp_usuario() {
		return ip_usuario;
	}

	public void setIp_usuario(String ip_usuario) {
		this.ip_usuario = ip_usuario;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	@Override
	public boolean equals(Object otra) {
		ParametrosEncuesta parametrosEncuesta = (ParametrosEncuesta) otra;
		return this.getId().equals(parametrosEncuesta.getId());
	}
}