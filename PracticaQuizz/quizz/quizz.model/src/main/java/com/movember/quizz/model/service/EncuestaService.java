package com.movember.quizz.model.service;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.movember.quizz.model.bean.Encuesta;
import com.movember.quizz.model.bean.ParametrosEncuesta;
import com.movember.quizz.model.bean.Pregunta;
import com.movember.quizz.model.dao.IEncuestaDAO;
import com.movember.quizz.model.exception.AppException;

@Service
class EncuestaService implements IEncuestaService {

	@Inject
	private IEncuestaDAO encuestaDAO;
	@Inject
	private IPreguntaService preguntaService;

	public void insert(Encuesta encuesta) throws AppException {
		try {
			encuestaDAO.insert(encuesta);
			if (encuesta.getPreguntas() != null && encuesta.getPreguntas().size() > 0) {
				for (Pregunta pregunta : encuesta.getPreguntas()) {
					pregunta.setId_encuesta(encuesta.getId());
					this.preguntaService.insert(pregunta);
				}
			}
		}
		catch (SQLException e) {
			throw new AppException("Se ha producido un error al insertar la encuesta");
		}
	}

	public void update(Encuesta encuesta) throws AppException {
		try {
			encuestaDAO.update(encuesta);
			if (encuesta.getPreguntas() != null && encuesta.getPreguntas().size() > 0) {
				List<Pregunta> preguntasAntiguas = this.preguntaService.recuperarDeEncuesta(encuesta.getId());
				for (Pregunta pregunta : encuesta.getPreguntas()) {
					if (pregunta.getId() != null) {
						this.preguntaService.update(pregunta);
					}
					else {
						this.preguntaService.insert(pregunta);
					}
				}

				// Borramos las que no estén
				for (Pregunta preguntaOld : preguntasAntiguas) {
					if (!encuesta.getPreguntas().contains(preguntaOld)) {
						this.preguntaService.delete(preguntaOld);
					}
				}
			}
		}
		catch (SQLException e) {
			throw new AppException("Se ha producido un error al actualizar la encuesta");
		}
	}

	public void delete(Encuesta encuesta) throws AppException {
		try {
			if (encuesta.getPreguntas() != null && encuesta.getPreguntas().size() > 0) {
				for (Pregunta pregunta : encuesta.getPreguntas()) {
					this.preguntaService.delete(pregunta);
				}
			}
			encuestaDAO.delete(encuesta.getId());
		}
		catch (SQLException e) {
			throw new AppException("Se ha producido un error al eliminar la encuesta");
		}
	}

	public Encuesta retrieve(Integer id) throws AppException {
		Encuesta encuesta = null;
		try {
			encuesta = encuestaDAO.retrieve(id);
			if (encuesta != null) {
				encuesta.setPreguntas(this.preguntaService.recuperarDeEncuesta(id));
			}
		}
		catch (SQLException e) {
			throw new AppException("Se ha producido un error al recuperar la encuesta");
		}
		return encuesta;
	}

	public List<Encuesta> selectAll() throws AppException {
		List<Encuesta> encuestas = null;
		try {
			encuestas = encuestaDAO.selectAll();
		}
		catch (SQLException e) {
			throw new AppException("Se ha producido un error al recuperar todas las encuestas");
		}
		return encuestas;
	}

	public List<Encuesta> find(ParametrosEncuesta parametrosEncuesta) throws AppException {
		List<Encuesta> encuestas = null;
		try {
			encuestas = encuestaDAO.find(parametrosEncuesta);
		}
		catch (SQLException e) {
			throw new AppException("Se ha producido un error al recuperar un listado de encuestas");
		}
		return encuestas;
	}
}
