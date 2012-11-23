package com.movember.quizz.model.repository;

import java.util.List;
import javax.inject.Inject;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.movember.quizz.model.bean.UsuarioAnonimo;

public class UsuarioAnonimoRepository implements IUsuarioAnonimoRepository {

	@Inject
	private HibernateTemplate hibernateTemplate;

	public void save(UsuarioAnonimo usuarioAnonimo) {
		hibernateTemplate.save(usuarioAnonimo);
	}

	public void update(UsuarioAnonimo usuarioAnonimo) {
		hibernateTemplate.update(usuarioAnonimo);
	}

	public void delete(UsuarioAnonimo usuarioAnonimo) {
		hibernateTemplate.delete(usuarioAnonimo);
	}

	public UsuarioAnonimo findOne(Long pId) {
		return hibernateTemplate.get(UsuarioAnonimo.class, pId);
	}

	public List<UsuarioAnonimo> findAll() {
		return hibernateTemplate.loadAll(UsuarioAnonimo.class);
	}
}
