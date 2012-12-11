package com.movember.quizz.controller.control;

import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = "/home*", method = RequestMethod.GET)
	public String printWelcome(ModelMap model, Principal principal, HttpServletRequest request) {

		String name = principal.getName();
		model.addAttribute("username", name);
		model.addAttribute("message", "Spring Security Custom Form example");
		if (request.getHeader("user-agent").toLowerCase().contains("mobile")) {
			return "homeM";
		}
		return "home";

	}

	@RequestMapping(value = "/login*", method = RequestMethod.GET)
	public String login(ModelMap model, HttpServletRequest request) {
		if (request.getHeader("user-agent").toLowerCase().contains("mobile")) {
			return "loginM";
		}
		return "login";

	}

	@RequestMapping(value = "/loginfailed*", method = RequestMethod.GET)
	public String loginerror(ModelMap model, HttpServletRequest request) {

		model.addAttribute("error", "true");
		if (request.getHeader("user-agent").toLowerCase().contains("mobile")) {
			return "loginM";
		}
		return "login";

	}

	@RequestMapping(value = "/logout*", method = RequestMethod.GET)
	public String logout(ModelMap model, HttpServletRequest request) {

		if (request.getHeader("user-agent").toLowerCase().contains("mobile")) {
			return "loginM";
		}
		return "login";

	}

}