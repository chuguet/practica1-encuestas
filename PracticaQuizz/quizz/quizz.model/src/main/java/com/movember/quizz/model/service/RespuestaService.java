package com.movember.quizz.model.service;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.movember.quizz.model.bean.Respuesta;
import com.movember.quizz.model.dao.IRespuestaDAO;
import com.movember.quizz.model.exception.AppException;

@Service
class RespuestaService implements IRespuestaService {

	@Inject
	private IRespuestaDAO respuestaDAO;

	public void insert(Respuesta respuesta) throws AppException {
		try {
			respuestaDAO.insert(respuesta);
		}
		catch (SQLException e) {
			throw new AppException("Se ha producido un error al insertar una respuesta");
		}
	}

	public void update(Respuesta respuesta) throws AppException {
		try {
			respuestaDAO.update(respuesta);
		}
		catch (SQLException e) {
			throw new AppException("Se ha producido un error al actualizar una respuesta");
		}
	}

	public void delete(Respuesta respuesta) throws AppException {
		try {
			respuestaDAO.delete(respuesta.getId());
		}
		catch (SQLException e) {
			throw new AppException("Se ha producido un error al eliminar una respuesta");
		}
	}

	public Respuesta retrieve(Integer id) throws AppException {
		Respuesta respuesta = null;
		try {
			respuesta = respuestaDAO.retrieve(id);
		}
		catch (SQLException e) {
			throw new AppException("Se ha producido un error al recuperar una respuesta");
		}
		return respuesta;
	}

	public List<Respuesta> selectAll() throws AppException {
		List<Respuesta> respuestas = null;
		try {
			respuestas = respuestaDAO.selectAll();
		}
		catch (SQLException e) {
			throw new AppException("Se ha producido un error al recuperar todas las respuestas");
		}
		return respuestas;
	}

	public List<Respuesta> recuperarDePregunta(Integer idPregunta) throws AppException {
		List<Respuesta> respuestas = null;
		try {
			respuestas = this.respuestaDAO.recuperarDePregunta(idPregunta);
		}
		catch (SQLException e) {
			throw new AppException("Se ha producido un error al recuperar todas las respuestas de una pregunta");
		}
		return respuestas;
	}
}
