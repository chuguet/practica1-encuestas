package com.spring3.rest.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="empleados")
public class EmpleadoLista {
	
	private int count;
	private List<Empleado> empleados;
	
	public EmpleadoLista() {}
	
	public EmpleadoLista(List<Empleado> empleados) {
		this.empleados = empleados;
		this.count = empleados.size();
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	@XmlElement(name="empleado")
	public List<Empleado> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}
}
