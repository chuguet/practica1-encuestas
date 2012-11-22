package com.movember.quizz.model.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.movember.quizz.model.bean.Encuesta;
import com.movember.quizz.model.repository.IRepositoryDAO;

@Service
class EncuestaService implements IEncuestaService {

	@Inject
	private IRepositoryDAO<Encuesta> repositoryDAO;

	public void save(Encuesta encuesta) {
		repositoryDAO.save(encuesta);
	}

	public void update(Encuesta encuesta) {
		repositoryDAO.save(encuesta);
	}

	public void delete(Encuesta encuesta) {
		repositoryDAO.save(encuesta);
	}

	public Encuesta findOne(Long pId) {
		return repositoryDAO.findOne(pId);
	}

	public List<Encuesta> findAll() {
		return repositoryDAO.findAll();
	}

}
