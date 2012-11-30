package com.movember.quizz.model.test;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.junit.Test;
import com.movember.quizz.model.bean.Encuesta;
import com.movember.quizz.model.bean.Pregunta;
import com.movember.quizz.model.bean.Usuario;
import com.movember.quizz.model.service.IUsuarioService;

// @Transactional
// @TransactionConfiguration(defaultRollback = false)
public class ServiceUsuarioTest extends AbstractTest {

	@Inject
	private IUsuarioService usuarioService;

	@Test
	public void testSave() {
		Usuario usuario = new Usuario("Carlos", "Huguet", "huguet10@gmail.com", "1234", "1234", 1);
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(usuario);

		List<Encuesta> encuestas = new ArrayList<Encuesta>();
		Encuesta encuesta = new Encuesta();
		encuesta.setNombre("Encuesta de Ralph Wiggum");
		encuesta.setUsuarios(usuarios);
		encuestas.add(encuesta);
		usuario.setEncuestas(encuestas);

		Pregunta pregunta = new Pregunta();
		pregunta.setEncuesta(encuesta);
		pregunta.setPregunta("For president?");
		List<Pregunta> preguntas = new ArrayList<Pregunta>();
		preguntas.add(pregunta);
		encuesta.setPreguntas(preguntas);

		usuarioService.save(usuario);
	}

}
