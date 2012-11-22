package com.movember.quizz.model.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.movember.quizz.model.bean.EncuestaUsuario;
import com.movember.quizz.model.repository.IRepositoryDAO;

@Service
class EncuestaUsuarioService implements IEncuestaUsuarioService {

	@Inject
	private IRepositoryDAO<EncuestaUsuario> repositoryDAO;

	public void save(EncuestaUsuario encuestaUsuario) {
		repositoryDAO.save(encuestaUsuario);
	}

	public void update(EncuestaUsuario encuestaUsuario) {
		repositoryDAO.update(encuestaUsuario);
	}

	public void delete(EncuestaUsuario encuestaUsuario) {
		repositoryDAO.delete(encuestaUsuario);
	}

	public EncuestaUsuario findOne(Long pId) {
		return repositoryDAO.findOne(pId);
	}

	public List<EncuestaUsuario> findAll() {
		return repositoryDAO.findAll();
	}

}
