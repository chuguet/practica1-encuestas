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
import com.movember.quizz.model.bean.Encuesta;
import com.movember.quizz.model.service.IEncuestaService;

@Controller
@RequestMapping("/encuesta/**")
public class EncuestaController {

	private IEncuestaService encuestaService;

	private static final String recurso = "encuesta";

	@Autowired
	public void setEncuestaService(IEncuestaService encuestaService) {
		this.encuestaService = encuestaService;
	}

	public IEncuestaService getEncuestaService() {
		return this.encuestaService;
	}

	@RequestMapping(value = "/" + recurso + "/{id}", method = RequestMethod.GET, produces = "text/html")
	public String retrieve(@PathVariable("id") Long id, final Model uiModel) {
		uiModel.addAttribute("encuesta", this.encuestaService.findOne(id));
		uiModel.addAttribute("itemId", id);
		return recurso + "/edit";
	}

	@RequestMapping(value = "/" + recurso, method = RequestMethod.GET, produces = "text/html")
	public String listAll(final Model uiModel) {
		List<Encuesta> encuestas = this.encuestaService.findAll();
		uiModel.addAttribute("encuestas", encuestas);
		return recurso + "/list";
	}

	@RequestMapping(value = "/" + recurso + "/form", method = RequestMethod.GET, produces = "text/html")
	public String createForm(final Model uiModel) {
		uiModel.addAttribute(recurso, new Encuesta());
		return recurso + "/new";
	}

	@RequestMapping(value = "/" + recurso, method = RequestMethod.POST)
	public String insert(@ModelAttribute("encuesta") Encuesta encuesta, BindingResult result) {
		if (encuesta == null) {
			throw new IllegalArgumentException("Una encuesta es requerida");
		}
		encuestaService.save(encuesta);
		return "redirect:/rest/" + recurso;
	}

	@RequestMapping(value = "/" + recurso + "/{id}", method = RequestMethod.POST)
	public String update(@ModelAttribute("encuesta") Encuesta encuesta, BindingResult result, Model uiModel) {
		if (encuesta == null) {
			throw new IllegalArgumentException("Un encuesta es requerida");
		}
		encuestaService.update(encuesta);
		return this.listAll(uiModel);
	}

	@RequestMapping(value = "/encuesta/{id}", method = RequestMethod.DELETE)
	public String remove(@PathVariable String id, Model uiModel) {
		Encuesta encuesta = new Encuesta();
		encuesta.setId(new Long(id));
		this.encuestaService.delete(encuesta);
		return this.listAll(uiModel);
	}
}
