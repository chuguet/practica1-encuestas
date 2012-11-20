package quizz.movember.controller.control;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import quizz.movember.controller.business.UsuarioBO;
import quizz.movember.model.bean.Usuario;

@Controller
public class UsuarioController {

	private UsuarioBO usuarioBO;

	private static final String recurso = "usuario";

	@Autowired
	public void setUsuarioBO(UsuarioBO usuarioBO) {
		this.usuarioBO = usuarioBO;
	}

	public UsuarioBO getUsuarioBO() {
		return this.usuarioBO;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/" + recurso + "/{id}")
	public ModelAndView retrieve(@PathVariable String id) {
		Usuario empleado = this.usuarioBO.get(Long.parseLong(id));
		return new ModelAndView("edit/" + recurso, recurso, empleado);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/" + recurso)
	public ModelAndView listAll() {
		List<Usuario> usuarios = this.usuarioBO.getAll();
		return new ModelAndView("list/" + recurso, "empleados", usuarios);
	}

	// @RequestMapping(method = RequestMethod.PUT, value = "/" + recurso +
	// "/{id}")
	// public ModelAndView update(@RequestBody String body) {
	// Source source = new StreamSource(new StringReader(body));
	// Usuario empleado = (Usuario) jaxb2Mashaller.unmarshal(source);
	// usuarioBO.update(empleado);
	// return new ModelAndView("edit/" + recurso, "object", empleado);
	// }
	//
	// @RequestMapping(method = RequestMethod.POST, value = "/" + recurso)
	// public ModelAndView insert(@RequestBody String body) {
	// Source source = new StreamSource(new StringReader(body));
	// Usuario empleado = (Usuario) jaxb2Mashaller.unmarshal(source);
	// usuarioBO.add(empleado);
	// return new ModelAndView("edit/" + recurso, "object", empleado);
	// }
	//
	// @RequestMapping(method = RequestMethod.DELETE, value = "/" + recurso +
	// "/{id}")
	// public ModelAndView remove(@PathVariable String id) {
	// usuarioBO.remove(Long.parseLong(id));
	// List<Usuario> empleados = usuarioBO.getAll();
	// UsuarioLista list = new UsuarioLista(empleados);
	// return new ModelAndView("list/" + recurso, recurso, list);
	// }
}
