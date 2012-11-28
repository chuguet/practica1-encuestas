package com.movember.quizz.model.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.movember.quizz.model.bean.Encuesta;
import com.movember.quizz.model.repository.IEncuestaRepository;

@Service
@Transactional(propagation = Propagation.MANDATORY)
class EncuestaService implements IEncuestaService {

	@Inject
	private IEncuestaRepository encuestaRepository;

	public void save(Encuesta encuesta) {
		encuestaRepository.save(encuesta);
	}

	public void update(Encuesta encuesta) {
		encuestaRepository.update(encuesta);
	}

	public void delete(Encuesta encuesta) {
		encuestaRepository.delete(encuesta);
	}

	public Encuesta findOne(Long pId) {
		return encuestaRepository.findOne(pId);
	}

	public List<Encuesta> findAll() {
		return encuestaRepository.findAll();
	}
}
