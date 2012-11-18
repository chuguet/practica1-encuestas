// package com.spring3.rest.controller;
//
// import java.io.StringReader;
// import java.util.List;
//
// import javax.xml.transform.Source;
// import javax.xml.transform.stream.StreamSource;
//
// import org.springframework.oxm.jaxb.Jaxb2Marshaller;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.servlet.ModelAndView;
//
// import com.spring3.rest.bean.Empleado;
// import com.spring3.rest.bean.EmpleadoLista;
// import com.spring3.rest.business.EmpleadoBO;
//
// @Controller
// public class EmpleadoController {
//
// private EmpleadoBO empleadoBO;
// private Jaxb2Marshaller jaxb2Mashaller;
//
// private static final String recurso ="empleado";
//
// public void setEmpleadoBO(EmpleadoBO empleadoBO) {
// this.empleadoBO = empleadoBO;
// }
//
// public EmpleadoBO getEmpleadoBO() {
// return this.empleadoBO;
// }
//
// public void setJaxb2Mashaller(Jaxb2Marshaller jaxb2Mashaller) {
// this.jaxb2Mashaller = jaxb2Mashaller;
// }
//
// @RequestMapping(method=RequestMethod.GET, value="/" + recurso + "/{id}")
// public ModelAndView retrieve(@PathVariable String id) {
// Empleado empleado = this.empleadoBO.get(Long.parseLong(id));
// return new ModelAndView("edit/" + recurso, recurso, empleado);
// }
//
// @RequestMapping(method=RequestMethod.GET, value="/" + recurso)
// public ModelAndView listAll() {
// List<Empleado> empleados = this.empleadoBO.getAll();
// EmpleadoLista list = new EmpleadoLista(empleados);
// return new ModelAndView("list/" + recurso, "empleados", list);
// }
//
// @RequestMapping(method=RequestMethod.PUT, value="/" + recurso + "/{id}")
// public ModelAndView update(@RequestBody String body) {
// Source source = new StreamSource(new StringReader(body));
// Empleado empleado = (Empleado) jaxb2Mashaller.unmarshal(source);
// empleadoBO.update(empleado);
// return new ModelAndView("edit/" + recurso, "object", empleado);
// }
//
// @RequestMapping(method=RequestMethod.POST, value="/" + recurso)
// public ModelAndView insert(@RequestBody String body) {
// Source source = new StreamSource(new StringReader(body));
// Empleado empleado = (Empleado) jaxb2Mashaller.unmarshal(source);
// empleadoBO.add(empleado);
// return new ModelAndView("edit/" + recurso, "object", empleado);
// }
//
// @RequestMapping(method=RequestMethod.DELETE, value="/" + recurso + "/{id}")
// public ModelAndView remove(@PathVariable String id) {
// empleadoBO.remove(Long.parseLong(id));
// List<Empleado> empleados = empleadoBO.getAll();
// EmpleadoLista list = new EmpleadoLista(empleados);
// return new ModelAndView("list/" + recurso, recurso, list);
// }
// }
