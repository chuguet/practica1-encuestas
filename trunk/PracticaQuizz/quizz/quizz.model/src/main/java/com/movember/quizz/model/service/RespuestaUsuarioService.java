package com.movember.quizz.model.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.movember.quizz.model.bean.RespuestaUsuario;
import com.movember.quizz.model.repository.IRespuestaUsuarioRepository;

@Service
class RespuestaUsuarioService implements IRespuestaUsuarioService {

	@Inject
	private IRespuestaUsuarioRepository respuestaUsuarioRepository;

	public void save(RespuestaUsuario respuestaUsuario) {
		respuestaUsuarioRepository.save(respuestaUsuario);
	}

	public void update(RespuestaUsuario respuestaUsuario) {
		respuestaUsuarioRepository.update(respuestaUsuario);
	}

	public void delete(RespuestaUsuario respuestaUsuario) {
		respuestaUsuarioRepository.delete(respuestaUsuario);
	}

	public RespuestaUsuario findOne(Long pId) {
		return respuestaUsuarioRepository.findOne(pId);
	}

	public List<RespuestaUsuario> findAll() {
		return respuestaUsuarioRepository.findAll();
	}

}
