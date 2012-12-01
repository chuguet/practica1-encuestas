package com.movember.quizz.model.dao;

import java.sql.SQLException;
import java.util.List;
import com.movember.quizz.model.bean.Pregunta;

public interface IPreguntaDAO extends IRepositoryDAO<Pregunta> {

	List<Pregunta> recuperarDeEncuesta(Integer idEncuesta) throws SQLException;

}
