// package com.spring3.rest.business;
//
// import java.util.List;
//
// import com.spring3.rest.bean.Empleado;
// import com.spring3.rest.dao.EmpleadoDAO;
//
// public class EmpleadoBO {
//
// private EmpleadoDAO empleadoDAO;
//
// public void setEmpleadoDAO(EmpleadoDAO empleadoDAO) {
// this.empleadoDAO = empleadoDAO;
// }
//
// public EmpleadoDAO getEmpleadoDAO() {
// return empleadoDAO;
// }
//
// public Empleado get(long id) {
// return this.empleadoDAO.retrieve(id);
// }
//
// public List<Empleado> getAll() {
// return this.empleadoDAO.listAll();
// }
//
// public void add(Empleado empleado) {
// this.empleadoDAO.insert(empleado);
// }
//
// public void remove(long id) {
// Empleado empleado = new Empleado();
// empleado.setId(id);
// this.empleadoDAO.delete(empleado);
// }
//
// public void update(Empleado empleado) {
// this.empleadoDAO.update(empleado);
// }
// }
