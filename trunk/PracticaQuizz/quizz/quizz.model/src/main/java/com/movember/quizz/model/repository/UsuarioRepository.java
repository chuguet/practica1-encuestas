package com.movember.quizz.model.repository;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import com.movember.quizz.model.bean.Usuario;

@Repository
class UsuarioRepository extends HibernateDaoSupport implements IUsuarioRepository {

	public void save(Usuario usuario) {
		getHibernateTemplate().save(usuario);
	}

	public void update(Usuario usuario) {
		getHibernateTemplate().delete(usuario);
	}

	public void delete(Usuario usuario) {
		getHibernateTemplate().delete(usuario);
	}

	public Usuario findOne(Long pId) {
		return (Usuario) getHibernateTemplate().find("from usuario where id=?", pId).get(0);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> findAll() {
		return (List<Usuario>) getHibernateTemplate().find("from usuario");
	}

}
