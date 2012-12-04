package com.movember.quizz.model.dao;

import java.sql.SQLException;
import com.movember.quizz.model.bean.Usuario;

public interface IUsuarioDAO extends IRepositoryDAO<Usuario> {

	Usuario selectByUser(String usuarioNombre) throws SQLException;

}
