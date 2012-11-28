package com.movember.quizz.controller.control;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.movember.quizz.model.bean.Usuario;
import com.movember.quizz.model.service.IUsuarioService;

@Controller
@RequestMapping("/usuario/**")
public class UsuarioController {

	private IUsuarioService usuarioService;

	private static final String recurso = "usuario";

	@Autowired
	public void setUsuarioService(IUsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public IUsuarioService getUsuarioService() {
		return this.usuarioService;
	}

	@RequestMapping(value = "/" + recurso + "/{id}", method = RequestMethod.GET, produces = "text/html")
	public String retrieve(@PathVariable("id") Long id, final Model uiModel) {
		uiModel.addAttribute("usuario", this.usuarioService.findOne(id));
		uiModel.addAttribute("itemId", id);
		return recurso + "/edit";
	}

	@RequestMapping(value = "/" + recurso, method = RequestMethod.GET, produces = "text/html")
	public String listAll(final Model uiModel) {
		List<Usuario> usuarios = this.usuarioService.findAll();
		uiModel.addAttribute("usuarios", usuarios);
		return recurso + "/list";
	}

	@RequestMapping(value = "/" + recurso + "/form", method = RequestMethod.GET, produces = "text/html")
	public String createForm(final Model uiModel) {
		uiModel.addAttribute(recurso, new Usuario());
		return recurso + "/new";
	}

	@RequestMapping(value = "/" + recurso, method = RequestMethod.POST)
	public String insert(@ModelAttribute("usuario") Usuario usuario, BindingResult result) {
		if (usuario == null) {
			throw new IllegalArgumentException("Un usuario es requerido");
		}
		usuarioService.save(usuario);
		return "redirect:/rest/" + recurso;
	}

	@RequestMapping(value = "/" + recurso + "/{id}", method = RequestMethod.POST)
	public String update(@ModelAttribute("usuario") Usuario usuario, BindingResult result, Model uiModel) {
		if (usuario == null) {
			throw new IllegalArgumentException("Un usuario es requerido");
		}
		usuarioService.update(usuario);
		return this.listAll(uiModel);
	}

	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
	public String remove(@PathVariable String id, Model uiModel) {
		Usuario usuario = new Usuario();
		usuario.setId(new Long(id));
		this.usuarioService.delete(usuario);
		return this.listAll(uiModel);
	}
}