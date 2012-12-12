package com.movember.quizz.model.dao;

import java.sql.SQLException;
import java.util.List;
import com.movember.quizz.model.bean.Respuesta;
import com.movember.quizz.model.exception.AppException;

public interface IRespuestaDAO extends IRepositoryDAO<Respuesta> {

	List<Respuesta> recuperarDePregunta(Integer idPregunta) throws SQLException;
	Integer recuperarVecesContestadas (Integer idRespuesta) throws SQLException;
	
}
