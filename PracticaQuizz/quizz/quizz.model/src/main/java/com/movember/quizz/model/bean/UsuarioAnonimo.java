package com.movember.quizz.model.bean;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "encuesta_usuario")
public class UsuarioAnonimo implements IModelTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "ID")
	private Long id;
	@Column(name = "IP_DISPOSITIVO", length = 20)
	private String ip_dispositivo;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ENCUESTAS_USUARIO")
	private Collection<Encuesta> encuestasUsuario;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "RESPUESTAS_USUARIO")
	private Collection<Respuesta> respuestasUsuario;

	public String getIp_dispositivo() {
		return ip_dispositivo;
	}

	public void setIp_dispositivo(String ip_dispositivo) {
		this.ip_dispositivo = ip_dispositivo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
