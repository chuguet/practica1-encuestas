package com.movember.quizz.model.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.movember.quizz.model.bean.Pregunta;
import com.movember.quizz.model.repository.IRepositoryDAO;

@Service
class PreguntaService implements IPreguntaService {

	@Inject
	private IRepositoryDAO<Pregunta> repositoryDAO;

	public void save(Pregunta pregunta) {
		repositoryDAO.save(pregunta);
	}

	public void update(Pregunta pregunta) {
		repositoryDAO.update(pregunta);
	}

	public void delete(Pregunta pregunta) {
		repositoryDAO.delete(pregunta);
	}

	public Pregunta findOne(Long pId) {
		return repositoryDAO.findOne(pId);
	}

	public List<Pregunta> findAll() {
		return repositoryDAO.findAll();
	}

}
