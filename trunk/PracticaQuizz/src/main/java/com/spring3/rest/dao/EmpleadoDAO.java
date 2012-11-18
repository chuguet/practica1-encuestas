package com.spring3.rest.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.classic.Session;

import com.spring3.rest.bean.Empleado;

public class EmpleadoDAO {

	public void insert(Empleado empleado) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(empleado);
		session.getTransaction().commit();
		session.close();
	}
	
	public void update(Empleado empleado) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(empleado);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(Empleado empleado) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(empleado);
		session.getTransaction().commit();
		session.close();
	}

	public Empleado retrieve(long pId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Empleado empleado = (Empleado)session.get(Empleado.class, pId);
		session.close();
		return empleado;
	}

	@SuppressWarnings("unchecked")
	public List<Empleado> listAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query q = session.createQuery("select x from Empleado x");
		List<Empleado> listaEmpleados = q.list();
		session.close();
		return listaEmpleados;
	}
}
