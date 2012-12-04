package com.movember.quizz.model.service;

import com.movember.quizz.model.bean.Usuario;

public interface IUsuarioService extends IService<Usuario> {

	Usuario selectByUser(String name);

}