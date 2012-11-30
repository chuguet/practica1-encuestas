package com.movember.quizz.model.repository;

import java.util.List;
import javax.inject.Inject;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.movember.quizz.model.bean.Encuesta;

@Repository
// @Transactional(propagation = Propagation.MANDATORY)
class EncuestaRepository implements IEncuestaRepository {

	@Inject
	private HibernateTemplate hibernateTemplate;

	public void save(Encuesta encuesta) {
		hibernateTemplate.save(encuesta);
	}

	public void update(Encuesta encuesta) {
		hibernateTemplate.update(encuesta);
	}

	public void delete(Encuesta encuesta) {
		hibernateTemplate.delete(encuesta);
	}

	public Encuesta findOne(Long pId) {
		return hibernateTemplate.get(Encuesta.class, pId);
	}

	public List<Encuesta> findAll() {
		return hibernateTemplate.loadAll(Encuesta.class);
	}

}
