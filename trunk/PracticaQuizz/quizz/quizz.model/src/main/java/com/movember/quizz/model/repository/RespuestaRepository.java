package com.movember.quizz.model.repository;

import java.util.List;
import javax.inject.Inject;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.movember.quizz.model.bean.Respuesta;

@Repository
// @Transactional(propagation = Propagation.MANDATORY)
class RespuestaRepository implements IRespuestaRepository {

	@Inject
	private HibernateTemplate hibernateTemplate;

	public void save(Respuesta respuesta) {
		hibernateTemplate.save(respuesta);
	}

	public void update(Respuesta respuesta) {
		hibernateTemplate.update(respuesta);
	}

	public void delete(Respuesta respuesta) {
		hibernateTemplate.delete(respuesta);
	}

	public Respuesta findOne(Long pId) {
		return hibernateTemplate.get(Respuesta.class, pId);
	}

	public List<Respuesta> findAll() {
		return hibernateTemplate.loadAll(Respuesta.class);
	}

}
