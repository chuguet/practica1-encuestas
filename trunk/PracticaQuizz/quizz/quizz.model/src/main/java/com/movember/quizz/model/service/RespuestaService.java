package com.movember.quizz.model.service;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.movember.quizz.model.bean.Respuesta;
import com.movember.quizz.model.dao.IRespuestaDAO;

@Service
class RespuestaService implements IRespuestaService {

	@Inject
	private IRespuestaDAO respuestaDAO;

	public void insert(Respuesta respuesta) {
		try {
			respuestaDAO.insert(respuesta);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Respuesta respuesta) {
		try {
			respuestaDAO.update(respuesta);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(Respuesta respuesta) {
		try {
			respuestaDAO.delete(respuesta.getId());
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Respuesta retrieve(Integer id) {
		Respuesta respuesta = null;
		try {
			respuesta = respuestaDAO.retrieve(id);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return respuesta;
	}

	public List<Respuesta> selectAll() {
		List<Respuesta> respuestas = null;
		try {
			respuestas = respuestaDAO.selectAll();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return respuestas;
	}

	public List<Respuesta> recuperarDePregunta(Integer idPregunta) {
		List<Respuesta> respuestas = null;
		try {
			respuestas = this.respuestaDAO.recuperarDePregunta(idPregunta);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return respuestas;
	}
}
