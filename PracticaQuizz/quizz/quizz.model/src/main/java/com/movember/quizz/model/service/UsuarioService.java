package com.movember.quizz.model.service;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.movember.quizz.model.bean.Usuario;
import com.movember.quizz.model.dao.IUsuarioDAO;

@Service
class UsuarioService implements IUsuarioService {

	@Inject
	private IUsuarioDAO usuarioDAO;

	public void insert(Usuario usuario) {
		try {
			usuarioDAO.insert(usuario);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Usuario usuario) {
		try {
			usuarioDAO.update(usuario);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(Usuario usuario) {
		try {
			usuarioDAO.delete(usuario.getId());
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Usuario retrieve(Integer id) {
		Usuario usuario = null;
		try {
			usuario = usuarioDAO.retrieve(id);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	public List<Usuario> selectAll() {
		List<Usuario> usuarios = null;
		try {
			usuarios = usuarioDAO.selectAll();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

}
