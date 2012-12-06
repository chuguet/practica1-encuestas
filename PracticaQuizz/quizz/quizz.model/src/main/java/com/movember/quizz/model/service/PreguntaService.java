package com.movember.quizz.model.service;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.movember.quizz.model.bean.Pregunta;
import com.movember.quizz.model.bean.Respuesta;
import com.movember.quizz.model.dao.IPreguntaDAO;
import com.movember.quizz.model.exception.AppException;

@Service
class PreguntaService implements IPreguntaService {

	@Inject
	private IPreguntaDAO preguntaDAO;
	@Inject
	private IRespuestaService respuestaService;

	public void insert(Pregunta pregunta) throws AppException {
		try {
			preguntaDAO.insert(pregunta);
			if (pregunta.getRespuestas() != null && pregunta.getRespuestas().size() > 0) {
				for (Respuesta respuesta : pregunta.getRespuestas()) {
					respuesta.setId_pregunta(pregunta.getId());
					this.respuestaService.insert(respuesta);
				}
			}
		}
		catch (SQLException e) {
			throw new AppException("Se ha producido un error al insertar una pregunta");
		}
	}

	public void update(Pregunta pregunta) throws AppException {
		try {
			preguntaDAO.update(pregunta);
			if (pregunta.getRespuestas() != null && pregunta.getRespuestas().size() > 0) {
				List<Respuesta> respuestasAntiguas = this.respuestaService.recuperarDePregunta(pregunta.getId());
				for (Respuesta respuesta : pregunta.getRespuestas()) {
					if (respuesta.getId() != null) {
						this.respuestaService.update(respuesta);
					}
					else {
						this.respuestaService.insert(respuesta);
					}
				}

				// Borramos las que no estén
				for (Respuesta respuestaOld : respuestasAntiguas) {
					if (!pregunta.getRespuestas().contains(respuestaOld)) {
						this.respuestaService.delete(respuestaOld);
					}
				}
			}
		}
		catch (SQLException e) {
			throw new AppException("Se ha producido un error al actualizar una pregunta");
		}
	}

	public void delete(Pregunta pregunta) throws AppException {
		try {
			if (pregunta.getRespuestas() != null && pregunta.getRespuestas().size() > 0) {
				for (Respuesta respuesta : pregunta.getRespuestas()) {
					this.respuestaService.delete(respuesta);
				}
			}
			preguntaDAO.delete(pregunta.getId());
		}
		catch (SQLException e) {
			throw new AppException("Se ha producido un error al borrar una pregunta");
		}
	}

	public Pregunta retrieve(Integer id) throws AppException {
		try {
			return preguntaDAO.retrieve(id);
		}
		catch (SQLException e) {
			throw new AppException("Se ha producido un error al recuperar una pregunta");
		}
	}

	public List<Pregunta> selectAll() throws AppException {
		try {
			return preguntaDAO.selectAll();
		}
		catch (SQLException e) {
			throw new AppException("Se ha producido un error al recuperar una pregunta");
		}
	}

	public List<Pregunta> recuperarDeEncuesta(Integer idEncuesta) throws AppException {
		try {
			List<Pregunta> preguntas = this.preguntaDAO.recuperarDeEncuesta(idEncuesta);
			for (Pregunta pregunta : preguntas) {
				pregunta.setRespuestas(this.respuestaService.recuperarDePregunta(pregunta.getId()));
			}
			return preguntas;
		}
		catch (SQLException e) {
			throw new AppException("Se ha producido un error al recuperar las preguntas de una encuesta");
		}
	}
}
