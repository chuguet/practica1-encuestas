package com.spring3.rest.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="empleado")
public class Empleado {
	private long id;
	private String nombre;
	private String email;
	private String expediente;
	private String telefono;
	private String movil;
	private String direccion;
	private String image;
	
	public Empleado() {}
	
	public Empleado(long id, String nombre, String email, String expediente, String telefono, String movil, String direccion, String image) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.expediente = expediente;
		this.telefono = telefono;
		this.movil = movil;
		this.direccion = direccion;
		this.image = image;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getExpediente() {
		return expediente;
	}
	
	public void setExpediente(String expediente) {
		this.expediente = expediente;
	}
	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	@Override
	public int hashCode() {
		return Integer.valueOf(expediente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (expediente == null) {
			if (other.expediente != null)
				return false;
		} else if (!expediente.equals(other.expediente))
			return false;
		return true;
	}
}
