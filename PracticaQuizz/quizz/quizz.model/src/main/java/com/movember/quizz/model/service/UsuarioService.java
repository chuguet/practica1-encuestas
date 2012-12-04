package com.movember.quizz.model.service;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import com.movember.quizz.model.bean.Usuario;
import com.movember.quizz.model.dao.IUsuarioDAO;

@Service
class UsuarioService implements IUsuarioService {

	@Inject
	private IUsuarioDAO usuarioDAO;
	private Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();

	public void insert(Usuario usuario) {
		try {
			this.encriptPwd(usuario);
			usuarioDAO.insert(usuario);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Usuario usuario) {
		try {
			this.encriptPwd(usuario);
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

	public Usuario selectByUser(String usuarioNombre) {
		Usuario usuario = null;
		try {
			usuario = usuarioDAO.selectByUser(usuarioNombre);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	private void encriptPwd(Usuario usuario) {
		String pwd = passwordEncoder.encodePassword(usuario.getPwd(), null);
		usuario.setPwd(pwd);
	}

}
