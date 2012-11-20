package quizz.movember.business;

import java.util.List;
import quizz.movember.model.bean.Usuario;
import quizz.movember.model.dao.UsuarioDAO;

public class UsuarioBO {

	private UsuarioDAO usuarioDAO;

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public Usuario get(long id) {
		return this.usuarioDAO.retrieve(id);
	}

	public List<Usuario> getAll() {
		return this.usuarioDAO.listAll();
	}

	public void add(Usuario usuario) {
		this.usuarioDAO.insert(usuario);
	}

	public void remove(long id) {
		Usuario usuario = new Usuario();
		usuario.setId(id);
		this.usuarioDAO.delete(usuario);
	}

	public void update(Usuario usuario) {
		this.usuarioDAO.update(usuario);
	}
}
