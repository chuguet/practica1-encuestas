package com.movember.quizz.model.service;

import com.movember.quizz.model.bean.Usuario;
import com.movember.quizz.model.exception.AppException;

public interface IUsuarioService extends IService<Usuario> {

	Usuario selectByUser(String name) throws AppException;

}