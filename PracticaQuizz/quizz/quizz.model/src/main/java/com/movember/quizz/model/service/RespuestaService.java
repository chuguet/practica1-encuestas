package com.movember.quizz.model.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.movember.quizz.model.bean.Respuesta;
import com.movember.quizz.model.repository.IRepositoryDAO;

@Service
class RespuestaService implements IRespuestaService {

	@Inject
	private IRepositoryDAO<Respuesta> repositoryDAO;

	public void save(Respuesta respuesta) {
		repositoryDAO.save(respuesta);
	}

	public void update(Respuesta respuesta) {
		repositoryDAO.update(respuesta);
	}

	public void delete(Respuesta respuesta) {
		repositoryDAO.delete(respuesta);
	}

	public Respuesta findOne(Long pId) {
		return repositoryDAO.findOne(pId);
	}

	public List<Respuesta> findAll() {
		return repositoryDAO.findAll();
	}

}
