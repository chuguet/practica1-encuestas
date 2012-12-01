package com.movember.quizz.controller.control;

import java.util.ArrayList;
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
import com.movember.quizz.controller.dto.UsuarioDTO;
import com.movember.quizz.model.bean.Usuario;
import com.movember.quizz.model.service.IUsuarioService;

@Controller
public class UsuarioController {
	@Inject
	private IUsuarioService usuarioService;

	private static final String recurso = "usuario";

	@RequestMapping(value = "/" + recurso + "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	UsuarioDTO retrieve(@PathVariable("id") Integer id) {
		Usuario usuario = this.usuarioService.retrieve(id);
		// Comversion a DTO
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.toRest(usuario);
		return usuarioDTO;
	}

	@RequestMapping(value = "/" + recurso, method = RequestMethod.GET)
	public @ResponseBody
	List<UsuarioDTO> listAll() {
		List<Usuario> usuarios = this.usuarioService.selectAll();
		// Conversion a DTO
		List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();
		for (Usuario usuario : usuarios) {
			UsuarioDTO e = new UsuarioDTO();
			e.toRest(usuario);
			usuariosDTO.add(e);
		}
		return usuariosDTO;
	}

	@RequestMapping(value = "/" + recurso + "/form/{operacion}", method = RequestMethod.GET, produces = "text/html")
	public String createForm(@PathVariable("operacion") String operacion, final Model uiModel) {
		uiModel.addAttribute("operacion", operacion);
		if (!operacion.equals("list")) {
			operacion = "form";
		}
		return recurso + "/" + operacion;
	}

	@RequestMapping(value = "/" + recurso, method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO insert(@RequestBody UsuarioDTO usuarioDTO) {
		MensajeDTO mensaje = new MensajeDTO();
		if (usuarioDTO == null) {
			mensaje.setMensaje("Un usuario es requerido");
			mensaje.setCorrecto(false);
			return mensaje;
		}

		Usuario usuario = new Usuario();
		usuarioDTO.toBusiness(usuario);

		usuarioService.insert(usuario);
		mensaje.setMensaje("Usuario creado correctamente");
		return mensaje;
	}

	@RequestMapping(value = "/" + recurso + "/{id}", method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO update(@RequestBody UsuarioDTO usuarioDTO) {
		MensajeDTO mensaje = new MensajeDTO();
		if (usuarioDTO == null) {
			mensaje.setMensaje("Un usuario es requerido");
			mensaje.setCorrecto(false);
			return mensaje;
		}
		Usuario usuario = new Usuario();
		usuarioDTO.toBusiness(usuario);
		usuarioService.update(usuario);

		mensaje.setMensaje("Usuario modificado correctamente");
		return mensaje;
	}

	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
	public MensajeDTO remove(@PathVariable Integer id, Model uiModel) {
		Usuario usuario = new Usuario();
		usuario.setId(id);
		this.usuarioService.delete(usuario);
		MensajeDTO mensaje = new MensajeDTO();
		mensaje.setMensaje("Usuario eliminada correctamente");
		return mensaje;
	}
}
