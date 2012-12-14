package com.movember.quizz.controller.control;

import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.movember.quizz.model.bean.Usuario;

@Controller
public class LoginController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String printWelcome(ModelMap model, Principal principal, HttpServletRequest request) {
		UsernamePasswordAuthenticationToken u = (UsernamePasswordAuthenticationToken) principal;

		if (u != null) {
			Usuario usuario = (Usuario) u.getPrincipal();
			model.addAttribute("nombre", usuario.getNombre());
			model.addAttribute("apellidos", usuario.getApellidos());
			model.addAttribute("id_usuario", usuario.getId());
		}
		else {
			model.addAttribute("nombre", "Usuario anónimo");
			model.addAttribute("apellidos", null);
			model.addAttribute("id_usuario", null);
		}
		model.addAttribute("ip_usuario", request.getRemoteAddr());
		if (request.getHeader("user-agent").toLowerCase().contains("mobile")) {
			model.addAttribute("mobile", true);
			return "home";
		}
		else {
			model.addAttribute("mobile", false);
			if (u != null) {
				return "home";
			}
			else {
				return "login";
			}
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model, HttpServletRequest request) {
		model.addAttribute("mobile", request.getHeader("user-agent").toLowerCase().contains("mobile"));
		return "login";
	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model, HttpServletRequest request) {
		model.addAttribute("error", "true");
		model.addAttribute("mobile", request.getHeader("user-agent").toLowerCase().contains("mobile"));
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model, HttpServletRequest request) {
		model.addAttribute("mobile", request.getHeader("user-agent").toLowerCase().contains("mobile"));
		return "login";
	}
}