package com.movember.quizz.controller.control;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movember.quizz.controller.dto.EstadisticaDTO;
import com.movember.quizz.model.bean.Estadistica;
import com.movember.quizz.model.exception.AppException;
import com.movember.quizz.model.service.IEstadisticaService;

@Controller
public class EstadisticaController {
	
	@Inject
	private IEstadisticaService estadisticaService;

	private static final String recurso = "estadistica";

	@RequestMapping(value = "/" + recurso + "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	EstadisticaDTO retrieve(@PathVariable("id") Integer id) {
		EstadisticaDTO estadisticaDTO = new EstadisticaDTO();
		try {
			Estadistica estadistica = this.estadisticaService.retrieve(id);
			// Comversion a DTO
			estadisticaDTO.toRest(estadistica);
		}
		catch (AppException e) {

		}
		return estadisticaDTO;
	}

	@RequestMapping(value = "/" + recurso + "/form/{operacion}", method = RequestMethod.GET, produces = "text/html")
	public String createForm(@PathVariable("operacion") String operacion, final Model uiModel) {
		return recurso + "/form";
	}
}
