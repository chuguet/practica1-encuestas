package com.movember.quizz.model.service;

import java.util.List;
import javax.inject.Inject;
import com.movember.quizz.model.bean.UsuarioAnonimo;
import com.movember.quizz.model.repository.IUsuarioAnonimoRepository;

public class UsuarioAnonimoService implements IUsuarioAnonimoService {

	@Inject
	private IUsuarioAnonimoRepository usuarioAnonimoRepository;

	public void save(UsuarioAnonimo usuarioAnonimo) {
		usuarioAnonimoRepository.save(usuarioAnonimo);
	}

	public void update(UsuarioAnonimo usuarioAnonimo) {
		usuarioAnonimoRepository.update(usuarioAnonimo);
	}

	public void delete(UsuarioAnonimo usuarioAnonimo) {
		usuarioAnonimoRepository.delete(usuarioAnonimo);
	}

	public UsuarioAnonimo findOne(Long pId) {
		return usuarioAnonimoRepository.findOne(pId);
	}

	public List<UsuarioAnonimo> findAll() {
		return usuarioAnonimoRepository.findAll();
	}

}
