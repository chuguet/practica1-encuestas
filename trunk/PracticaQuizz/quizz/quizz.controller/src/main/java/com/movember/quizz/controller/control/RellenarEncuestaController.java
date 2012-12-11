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
import com.movember.quizz.controller.dto.ParametrosEncuestaDTO;
import com.movember.quizz.model.bean.Encuesta;
import com.movember.quizz.model.bean.ParametrosEncuesta;
import com.movember.quizz.model.exception.AppException;
import com.movember.quizz.model.service.IEncuestaService;

@Controller
public class RellenarEncuestaController {
	@Inject
	private IEncuestaService encuestaService;

	private static final String recurso = "rellenarEncuesta";

	@RequestMapping(value = "/" + recurso + "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	EncuestaDTO retrieve(@PathVariable("id") Integer id) {

		EncuestaDTO encuestaDTO = new EncuestaDTO();
		try {
			Encuesta encuesta = this.encuestaService.retrieve(id);
			encuestaDTO.toRest(encuesta);
		}
		catch (AppException e) {

		}
		return encuestaDTO;
	}

	@RequestMapping(value = "/" + recurso, method = RequestMethod.GET)
	public @ResponseBody
	List<EncuestaDTO> listAll() {
		List<EncuestaDTO> encuestasDTO = new ArrayList<EncuestaDTO>();
		try {
			List<Encuesta> encuestas = this.encuestaService.selectAll();
			for (Encuesta encuesta : encuestas) {
				EncuestaDTO e = new EncuestaDTO();
				e.toRest(encuesta);
				encuestasDTO.add(e);
			}
		}
		catch (AppException e) {

		}
		return encuestasDTO;
	}

	@RequestMapping(value = "/" + recurso, method = RequestMethod.GET)
	public @ResponseBody
	List<EncuestaDTO> find(@RequestBody ParametrosEncuestaDTO parametrosEncuestaDTO) {
		List<EncuestaDTO> encuestasDTO = new ArrayList<EncuestaDTO>();
		try {
			ParametrosEncuesta parametrosEncuesta = new ParametrosEncuesta();
			parametrosEncuestaDTO.toBusiness(parametrosEncuesta);
			List<Encuesta> encuestas = this.encuestaService.find(parametrosEncuesta);
			for (Encuesta encuesta : encuestas) {
				EncuestaDTO e = new EncuestaDTO();
				e.toRest(encuesta);
				encuestasDTO.add(e);
			}
		}
		catch (AppException e) {

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
		try {
			Encuesta encuesta = new Encuesta();
			encuestaDTO.toBusiness(encuesta);
			encuestaService.insert(encuesta);
			mensaje.setMensaje("Encuesta creada correctamente");
		}
		catch (AppException e) {
			mensaje.setMensaje(e.getMessage());
		}
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
		try {
			Encuesta encuesta = new Encuesta();
			encuestaDTO.toBusiness(encuesta);
			encuestaService.update(encuesta);
			mensaje.setMensaje("Encuesta modificada correctamente");
		}
		catch (AppException e) {
			mensaje.setMensaje(e.getMessage());
		}
		return mensaje;
	}

	@RequestMapping(value = "/" + recurso + "/{id}", method = RequestMethod.DELETE)
	public MensajeDTO remove(@PathVariable Integer id, Model uiModel) {

		MensajeDTO mensaje = new MensajeDTO();
		try {
			Encuesta encuesta = new Encuesta();
			encuesta.setId(id);
			this.encuestaService.delete(encuesta);
			mensaje.setMensaje("Encuesta eliminada correctamente");
		}
		catch (AppException e) {
			mensaje.setMensaje(e.getMessage());
		}
		return mensaje;
	}
}
