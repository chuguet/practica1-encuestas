package com.movember.quizz.model.dao;

import java.sql.SQLException;
import java.util.List;
import com.movember.quizz.model.bean.Respuesta;
import com.movember.quizz.model.bean.RespuestaContestada;

/**
 * The Interface IRespuestaDAO.
 */
public interface IRespuestaDAO extends IRepositoryDAO<Respuesta> {

	/**
	 * Recuperar de pregunta.
	 * 
	 * @param idPregunta
	 *            the id pregunta
	 * @return the list
	 * @throws SQLException
	 *             the sQL exception
	 */
	List<Respuesta> recuperarDePregunta(Integer idPregunta) throws SQLException;

	/**
	 * Contestar.
	 * 
	 * @param respuestaContestada
	 *            the respuesta contestada
	 * @throws SQLException
	 *             the sQL exception
	 */
	void contestar(RespuestaContestada respuestaContestada) throws SQLException;

	Integer recuperarVecesContestadasPorNoIdentificado(Integer idRespuesta) throws SQLException;

	Integer recuperarVecesContestadasPorIdentificado(Integer idRespuesta) throws SQLException;

}
