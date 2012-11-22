package com.movember.quizz.model.repository;

import java.util.List;
import javax.inject.Inject;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.movember.quizz.model.bean.EncuestaUsuario;

@Repository
class EncuestaUsuarioRepository implements IEncuestaUsuarioRepository {

	@Inject
	private HibernateTemplate hibernateTemplate;

	public void save(EncuestaUsuario encuestaUsuario) {
		hibernateTemplate.save(encuestaUsuario);
	}

	public void update(EncuestaUsuario encuestaUsuario) {
		hibernateTemplate.update(encuestaUsuario);
	}

	public void delete(EncuestaUsuario encuestaUsuario) {
		hibernateTemplate.delete(encuestaUsuario);
	}

	public EncuestaUsuario findOne(Long pId) {
		return hibernateTemplate.get(EncuestaUsuario.class, pId);
	}

	public List<EncuestaUsuario> findAll() {
		return hibernateTemplate.loadAll(EncuestaUsuario.class);
	}

}
