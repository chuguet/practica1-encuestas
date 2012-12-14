package com.movember.quizz.model.dao;

import java.sql.SQLException;
import java.util.List;
import com.movember.quizz.model.bean.Encuesta;
import com.movember.quizz.model.bean.EncuestaContestada;
import com.movember.quizz.model.bean.ParametrosEncuesta;

public interface IEncuestaDAO extends IRepositoryDAO<Encuesta> {

	List<Encuesta> find(ParametrosEncuesta parametrosEncuesta) throws SQLException;

	void contestar(EncuestaContestada encuestaRellenada) throws SQLException;

}