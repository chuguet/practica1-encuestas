package com.movember.quizz.model.dao;

import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.movember.quizz.model.bean.Encuesta;
import com.movember.quizz.model.bean.EncuestaContestada;
import com.movember.quizz.model.bean.ParametrosEncuesta;

@Repository
class EncuestaDAO extends AbstractDAO implements IEncuestaDAO {

	private static final long serialVersionUID = 1L;

	public void insert(Encuesta encuesta) throws SQLException {
		Integer id = (Integer) this.getSqlMapClient().insert("encuesta.insertReturnId", encuesta);
		encuesta.setId(id);
	}

	public void update(Encuesta encuesta) throws SQLException {
		this.getSqlMapClient().update("encuesta.updateByPrimaryKey", encuesta);
	}

	public void delete(Integer id) throws SQLException {
		this.getSqlMapClient().delete("encuesta.deleteByPrimaryKey", id);
	}

	public Encuesta retrieve(Integer id) throws SQLException {
		return (Encuesta) this.getSqlMapClient().queryForObject("encuesta.selectById", id);
	}

	public List<Encuesta> selectAll() throws SQLException {
		return (List<Encuesta>) this.getSqlMapClient().queryForList("encuesta.selectAll");
	}

	public List<Encuesta> selectByCriterios() throws SQLException {
		return (List<Encuesta>) this.getSqlMapClient().queryForList("encuesta.selectAll");
	}

	public List<Encuesta> find(ParametrosEncuesta parametrosEncuesta) throws SQLException {
		return (List<Encuesta>) this.getSqlMapClient().queryForList("encuesta.find", parametrosEncuesta);
	}

	public void contestar(EncuestaContestada encuestaContestada) throws SQLException {
		Integer id = (Integer) this.getSqlMapClient().insert("encuesta.contestar", encuestaContestada);
		encuestaContestada.setId(id);
	}
}