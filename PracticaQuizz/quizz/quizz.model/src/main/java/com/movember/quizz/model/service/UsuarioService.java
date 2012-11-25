package com.movember.quizz.model.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.movember.quizz.model.bean.Usuario;
import com.movember.quizz.model.repository.IUsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService {

	@Inject
	private IUsuarioRepository usuarioRepository;

	public void save(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	public void update(Usuario usuario) {
		usuarioRepository.update(usuario);
	}

	public void delete(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}

	public Usuario findOne(Long pId) {
		return usuarioRepository.findOne(pId);
	}

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
}
