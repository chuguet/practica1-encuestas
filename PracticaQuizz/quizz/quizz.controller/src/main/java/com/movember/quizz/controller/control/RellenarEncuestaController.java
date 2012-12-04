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
import com.movember.quizz.controller.dto.EncuestaDTO;
import com.movember.quizz.controller.dto.MensajeDTO;
import com.movember.quizz.model.bean.Encuesta;
import com.movember.quizz.model.service.IEncuestaService;

@Controller
public class RellenarEncuestaController {
	@Inject
	private IEncuestaService encuestaService;

	private static final String recurso = "rellenarEncuesta";

	@RequestMapping(value = "/" + recurso + "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	EncuestaDTO retrieve(@PathVariable("id") Integer id) {
		Encuesta encuesta = this.encuestaService.retrieve(id);
		// Comversion a DTO
		EncuestaDTO encuestaDTO = new EncuestaDTO();
		encuestaDTO.toRest(encuesta);
		return encuestaDTO;
	}

	@RequestMapping(value = "/" + recurso, method = RequestMethod.GET)
	public @ResponseBody
	List<EncuestaDTO> listAll() {
		List<Encuesta> encuestas = this.encuestaService.selectAll();
		// Conversion a DTO
		List<EncuestaDTO> encuestasDTO = new ArrayList<EncuestaDTO>();
		for (Encuesta encuesta : encuestas) {
			EncuestaDTO e = new EncuestaDTO();
			e.toRest(encuesta);
			encuestasDTO.add(e);
		}
		return encuestasDTO;
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
	MensajeDTO insert(@RequestBody EncuestaDTO encuestaDTO) {
		MensajeDTO mensaje = new MensajeDTO();
		if (encuestaDTO == null) {
			mensaje.setMensaje("Una encuesta es requerida");
			mensaje.setCorrecto(false);
			return mensaje;
		}

		Encuesta encuesta = new Encuesta();
		encuestaDTO.toBusiness(encuesta);

		encuestaService.insert(encuesta);
		mensaje.setMensaje("Encuesta creada correctamente");
		return mensaje;
	}

	@RequestMapping(value = "/" + recurso + "/{id}", method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO update(@RequestBody EncuestaDTO encuestaDTO) {
		MensajeDTO mensaje = new MensajeDTO();
		if (encuestaDTO == null) {
			mensaje.setMensaje("Una encuesta es requerida");
			mensaje.setCorrecto(false);
			return mensaje;
		}
		Encuesta encuesta = new Encuesta();
		encuestaDTO.toBusiness(encuesta);
		encuestaService.update(encuesta);

		mensaje.setMensaje("Encuesta modificada correctamente");
		return mensaje;
	}

	@RequestMapping(value = "/" + recurso + "/{id}", method = RequestMethod.DELETE)
	public MensajeDTO remove(@PathVariable Integer id, Model uiModel) {
		Encuesta encuesta = new Encuesta();
		encuesta.setId(id);
		this.encuestaService.delete(encuesta);
		MensajeDTO mensaje = new MensajeDTO();
		mensaje.setMensaje("Encuesta eliminada correctamente");
		return mensaje;
	}
}
