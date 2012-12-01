package com.movember.quizz.model.service;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.movember.quizz.model.bean.Pregunta;
import com.movember.quizz.model.bean.Respuesta;
import com.movember.quizz.model.dao.IPreguntaDAO;

@Service
class PreguntaService implements IPreguntaService {

	@Inject
	private IPreguntaDAO preguntaDAO;
	@Inject
	private IRespuestaService respuestaService;

	public void insert(Pregunta pregunta) {
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
			e.printStackTrace();
		}
	}

	public void update(Pregunta pregunta) {
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
			e.printStackTrace();
		}
	}

	public void delete(Pregunta pregunta) {
		try {
			if (pregunta.getRespuestas() != null && pregunta.getRespuestas().size() > 0) {
				for (Respuesta respuesta : pregunta.getRespuestas()) {
					this.respuestaService.delete(respuesta);
				}
			}
			preguntaDAO.delete(pregunta.getId());
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Pregunta retrieve(Integer id) {
		Pregunta pregunta = null;
		try {
			pregunta = preguntaDAO.retrieve(id);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return pregunta;
	}

	public List<Pregunta> selectAll() {
		List<Pregunta> preguntas = null;
		try {
			preguntas = preguntaDAO.selectAll();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return preguntas;
	}

	public List<Pregunta> recuperarDeEncuesta(Integer idEncuesta) {
		List<Pregunta> preguntas = null;
		try {
			preguntas = this.preguntaDAO.recuperarDeEncuesta(idEncuesta);
			for (Pregunta pregunta : preguntas) {
				pregunta.setRespuestas(this.respuestaService.recuperarDePregunta(pregunta.getId()));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return preguntas;
	}

}
