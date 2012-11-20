package quizz.movember.model.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Component;
import quizz.movember.model.bean.Usuario;

@Component
public class UsuarioDAO {

	public void insert(Usuario empleado) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(empleado);
		session.getTransaction().commit();
		session.close();
	}

	public void update(Usuario empleado) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(empleado);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(Usuario empleado) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(empleado);
		session.getTransaction().commit();
		session.close();
	}

	public Usuario retrieve(long pId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Usuario empleado = (Usuario) session.get(Usuario.class, pId);
		session.close();
		return empleado;
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query q = session.createQuery("select x from Usuario x");
		List<Usuario> listaUsuarios = q.list();
		session.close();
		return listaUsuarios;
	}
}
