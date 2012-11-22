package com.movember.quizz.model.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.movember.quizz.model.bean.Usuario;
import com.movember.quizz.model.repository.IRepositoryDAO;

@Service
class UsuarioService implements IUsuarioService {

	@Inject
	private IRepositoryDAO<Usuario> repositoryDAO;

	public void save(Usuario usuario) {
		repositoryDAO.save(usuario);
	}

	public void update(Usuario usuario) {
		repositoryDAO.update(usuario);
	}

	public void delete(Usuario usuario) {
		repositoryDAO.delete(usuario);
	}

	public Usuario findOne(Long pId) {
		return repositoryDAO.findOne(pId);
	}

	public List<Usuario> findAll() {
		return repositoryDAO.findAll();
	}

}
