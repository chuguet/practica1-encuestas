package com.movember.quizz.model.service;

import com.movember.quizz.model.bean.Usuario;

public interface IUsuarioService extends IModelService<Usuario> {

	void save(Usuario usuario);

	void update(Usuario usuario);

	void delete(Usuario usuario);

	Usuario findOne(Long pId);

}
