package com.movember.quizz.model.service;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.movember.quizz.model.bean.Encuesta;
import com.movember.quizz.model.bean.Pregunta;
import com.movember.quizz.model.dao.IEncuestaDAO;

@Service
class EncuestaService implements IEncuestaService {

	@Inject
	private IEncuestaDAO encuestaDAO;
	@Inject
	private IPreguntaService preguntaService;

	public void insert(Encuesta encuesta) {
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
			e.printStackTrace();
		}
	}

	public void update(Encuesta encuesta) {
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
			e.printStackTrace();
		}
	}

	public void delete(Encuesta encuesta) {
		try {
			if (encuesta.getPreguntas() != null && encuesta.getPreguntas().size() > 0) {
				for (Pregunta pregunta : encuesta.getPreguntas()) {
					this.preguntaService.delete(pregunta);
				}
			}
			encuestaDAO.delete(encuesta.getId());
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Encuesta retrieve(Integer id) {
		Encuesta encuesta = null;
		try {
			encuesta = encuestaDAO.retrieve(id);
			if (encuesta != null) {
				encuesta.setPreguntas(this.preguntaService.recuperarDeEncuesta(id));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return encuesta;
	}

	public List<Encuesta> selectAll() {
		List<Encuesta> encuestas = null;
		try {
			encuestas = encuestaDAO.selectAll();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return encuestas;
	}
}
