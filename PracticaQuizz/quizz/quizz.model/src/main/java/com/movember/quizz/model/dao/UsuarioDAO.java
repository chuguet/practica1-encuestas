package com.movember.quizz.model.dao;

import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.movember.quizz.model.bean.Usuario;

@Repository
class UsuarioDAO extends AbstractDAO implements IUsuarioDAO {

	private static final long serialVersionUID = 1L;

	public void insert(Usuario usuario) throws SQLException {
		Integer id = (Integer) this.getSqlMapClient().insert("usuario.insertReturnId", usuario);
		usuario.setId(id);
	}

	public void update(Usuario usuario) throws SQLException {
		this.getSqlMapClient().update("usuario.updateByPrimaryKey", usuario);
	}

	public void delete(Integer id) throws SQLException {
		this.getSqlMapClient().delete("usuario.deleteByPrimaryKey", id);
	}

	public Usuario retrieve(Integer id) throws SQLException {
		return (Usuario) this.getSqlMapClient().queryForObject("usuario.selectById", id);
	}

	public List<Usuario> selectAll() throws SQLException {
		return (List<Usuario>) this.getSqlMapClient().queryForList("usuario.selectAll");
	}

	public List<Usuario> selectByCriterios() throws SQLException {
		return (List<Usuario>) this.getSqlMapClient().queryForList("usuario.selectAll");
	}
}