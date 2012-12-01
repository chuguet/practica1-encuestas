package com.movember.quizz.model.dao;

import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.movember.quizz.model.bean.Pregunta;

@Repository
class PreguntaDAO extends AbstractDAO implements IPreguntaDAO {

	private static final long serialVersionUID = 1L;

	public void insert(Pregunta pregunta) throws SQLException {
		Integer id = (Integer) this.getSqlMapClient().insert("pregunta.insertReturnId", pregunta);
		pregunta.setId(id);
	}

	public void update(Pregunta pregunta) throws SQLException {
		this.getSqlMapClient().update("pregunta.updateByPrimaryKey", pregunta);
	}

	public void delete(Integer id) throws SQLException {
		this.getSqlMapClient().delete("pregunta.deleteByPrimaryKey", id);
	}

	public Pregunta retrieve(Integer id) throws SQLException {
		return (Pregunta) this.getSqlMapClient().queryForObject("pregunta.selectById", id);
	}

	public List<Pregunta> selectAll() throws SQLException {
		return (List<Pregunta>) this.getSqlMapClient().queryForList("pregunta.selectAll");
	}

	public List<Pregunta> selectByCriterios() throws SQLException {
		return (List<Pregunta>) this.getSqlMapClient().queryForList("pregunta.selectAll");
	}

	public List<Pregunta> recuperarDeEncuesta(Integer idEncuesta) throws SQLException {
		return (List<Pregunta>) this.getSqlMapClient().queryForList("pregunta.recuperarDeEncuesta", idEncuesta);
	}
}