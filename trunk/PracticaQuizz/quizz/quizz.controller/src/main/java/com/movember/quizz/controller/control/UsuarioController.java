package com.movember.quizz.controller.control;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.movember.quizz.controller.dto.MensajeDTO;
import com.movember.quizz.model.bean.Usuario;
import com.movember.quizz.model.service.IUsuarioService;

@Controller
public class UsuarioController {
	@Inject
	private IUsuarioService usuarioService;

	private static final String recurso = "usuario";

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
	public @ResponseBody
	MensajeDTO insert(@RequestBody Usuario usuario) {
		if (usuario == null) {
			throw new IllegalArgumentException("Un usuario es requerido");
		}
		usuarioService.save(usuario);
		MensajeDTO mensaje = new MensajeDTO();
		mensaje.setMensaje("Usuario creado correctamente");
		return mensaje;
	}

	@RequestMapping(value = "/" + recurso + "/{id}", method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO update(@RequestBody Usuario usuario) {
		if (usuario == null) {
			throw new IllegalArgumentException("Un usuario es requerido");
		}
		usuarioService.update(usuario);
		MensajeDTO mensaje = new MensajeDTO();
		mensaje.setMensaje("Usuario modificado correctamente");
		return mensaje;
	}

	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	MensajeDTO remove(Usuario usuario) {
		this.usuarioService.delete(usuario);
		MensajeDTO mensaje = new MensajeDTO();
		mensaje.setMensaje("Usuario eliminado correctamente");
		return mensaje;
	}
}
