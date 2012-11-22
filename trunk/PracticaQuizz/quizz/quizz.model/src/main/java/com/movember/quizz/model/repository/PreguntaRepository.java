package com.movember.quizz.model.repository;

import java.util.List;
import javax.inject.Inject;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.movember.quizz.model.bean.Pregunta;

@Repository
class PreguntaRepository implements IPreguntaRepository {

	@Inject
	private HibernateTemplate hibernateTemplate;

	public void save(Pregunta pregunta) {
		hibernateTemplate.save(pregunta);
	}

	public void update(Pregunta pregunta) {
		hibernateTemplate.update(pregunta);
	}

	public void delete(Pregunta pregunta) {
		hibernateTemplate.delete(pregunta);
	}

	public Pregunta findOne(Long pId) {
		return hibernateTemplate.get(Pregunta.class, pId);
	}

	public List<Pregunta> findAll() {
		return hibernateTemplate.loadAll(Pregunta.class);
	}

}
