package com.movember.quizz.model.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.movember.quizz.model.bean.Respuesta;
import com.movember.quizz.model.repository.IRespuestaRepository;

@Service
// @Transactional(propagation = Propagation.MANDATORY)
class RespuestaService implements IRespuestaService {

	@Inject
	private IRespuestaRepository respuestaRepository;

	public void save(Respuesta respuesta) {
		respuestaRepository.save(respuesta);
	}

	public void update(Respuesta respuesta) {
		respuestaRepository.update(respuesta);
	}

	public void delete(Respuesta respuesta) {
		respuestaRepository.delete(respuesta);
	}

	public Respuesta findOne(Long pId) {
		return respuestaRepository.findOne(pId);
	}

	public List<Respuesta> findAll() {
		return respuestaRepository.findAll();
	}

}
