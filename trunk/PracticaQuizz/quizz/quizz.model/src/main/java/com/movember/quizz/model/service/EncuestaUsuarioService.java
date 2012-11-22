package com.movember.quizz.model.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.movember.quizz.model.bean.EncuestaUsuario;
import com.movember.quizz.model.repository.IEncuestaUsuarioRepository;

@Service
class EncuestaUsuarioService implements IEncuestaUsuarioService {

	@Inject
	private IEncuestaUsuarioRepository encuestaUsuarioRepository;

	public void save(EncuestaUsuario encuestaUsuario) {
		encuestaUsuarioRepository.save(encuestaUsuario);
	}

	public void update(EncuestaUsuario encuestaUsuario) {
		encuestaUsuarioRepository.update(encuestaUsuario);
	}

	public void delete(EncuestaUsuario encuestaUsuario) {
		encuestaUsuarioRepository.delete(encuestaUsuario);
	}

	public EncuestaUsuario findOne(Long pId) {
		return encuestaUsuarioRepository.findOne(pId);
	}

	public List<EncuestaUsuario> findAll() {
		return encuestaUsuarioRepository.findAll();
	}

}
