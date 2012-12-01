package com.movember.quizz.model.dao;

import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.movember.quizz.model.bean.Respuesta;

@Repository
class RespuestaDAO extends AbstractDAO implements IRespuestaDAO {

	private static final long serialVersionUID = 1L;

	public void insert(Respuesta respuesta) throws SQLException {
		Integer id = (Integer) this.getSqlMapClient().insert("respuesta.insertReturnId", respuesta);
		respuesta.setId(id);
	}

	public void update(Respuesta respuesta) throws SQLException {
		this.getSqlMapClient().update("respuesta.updateByPrimaryKey", respuesta);
	}

	public void delete(Integer id) throws SQLException {
		this.getSqlMapClient().delete("respuesta.deleteByPrimaryKey", id);
	}

	public Respuesta retrieve(Integer id) throws SQLException {
		return (Respuesta) this.getSqlMapClient().queryForObject("respuesta.selectById", id);
	}

	public List<Respuesta> selectAll() throws SQLException {
		return (List<Respuesta>) this.getSqlMapClient().queryForList("respuesta.selectAll");
	}

	public List<Respuesta> selectByCriterios() throws SQLException {
		return (List<Respuesta>) this.getSqlMapClient().queryForList("respuesta.selectAll");
	}

	public List<Respuesta> recuperarDePregunta(Integer idPregunta) throws SQLException {
		return (List<Respuesta>) this.getSqlMapClient().queryForList("respuesta.recuperarDePregunta", idPregunta);
	}
}