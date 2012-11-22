package com.movember.quizz.model.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.movember.quizz.model.bean.RespuestaUsuario;
import com.movember.quizz.model.repository.IRepositoryDAO;

@Service
class RespuestaUsuarioService implements IRespuestaUsuarioService {

	@Inject
	private IRepositoryDAO<RespuestaUsuario> repositoryDAO;

	public void save(RespuestaUsuario respuestaUsuario) {
		repositoryDAO.save(respuestaUsuario);
	}

	public void update(RespuestaUsuario respuestaUsuario) {
		repositoryDAO.update(respuestaUsuario);
	}

	public void delete(RespuestaUsuario respuestaUsuario) {
		repositoryDAO.delete(respuestaUsuario);
	}

	public RespuestaUsuario findOne(Long pId) {
		return repositoryDAO.findOne(pId);
	}

	public List<RespuestaUsuario> findAll() {
		return repositoryDAO.findAll();
	}

}
