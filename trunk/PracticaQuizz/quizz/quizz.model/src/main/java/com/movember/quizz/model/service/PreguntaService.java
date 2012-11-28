package com.movember.quizz.model.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.movember.quizz.model.bean.Pregunta;
import com.movember.quizz.model.repository.IPreguntaRepository;

@Service
@Transactional(propagation = Propagation.MANDATORY)
class PreguntaService implements IPreguntaService {

	@Inject
	private IPreguntaRepository preguntaRepository;

	public void save(Pregunta pregunta) {
		preguntaRepository.save(pregunta);
	}

	public void update(Pregunta pregunta) {
		preguntaRepository.update(pregunta);
	}

	public void delete(Pregunta pregunta) {
		preguntaRepository.delete(pregunta);
	}

	public Pregunta findOne(Long pId) {
		return preguntaRepository.findOne(pId);
	}

	public List<Pregunta> findAll() {
		return preguntaRepository.findAll();
	}

}
