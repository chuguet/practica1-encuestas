package com.movember.quizz.model.repository;

import java.util.List;
import com.movember.quizz.model.bean.Usuario;

public interface IUsuarioRepository {
	void save(Usuario usuario);

	void update(Usuario usuario);

	void delete(Usuario usuario);

	Usuario findOne(Long pId);

	List<Usuario> findAll();
}
