package com.movember.quizz.model.repository;

import java.util.List;
import javax.inject.Inject;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.movember.quizz.model.bean.RespuestaUsuario;

@Repository
class RespuestaUsuarioRepository implements IRespuestaUsuarioRepository {

	@Inject
	private HibernateTemplate hibernateTemplate;

	public void save(RespuestaUsuario respuestaUsuario) {
		hibernateTemplate.save(respuestaUsuario);
	}

	public void update(RespuestaUsuario respuestaUsuario) {
		hibernateTemplate.update(respuestaUsuario);
	}

	public void delete(RespuestaUsuario respuestaUsuario) {
		hibernateTemplate.delete(respuestaUsuario);
	}

	public RespuestaUsuario findOne(Long pId) {
		return hibernateTemplate.get(RespuestaUsuario.class, pId);
	}

	public List<RespuestaUsuario> findAll() {
		return hibernateTemplate.loadAll(RespuestaUsuario.class);
	}

}
