package com.movember.quizz.model.service;

import java.util.List;
import com.movember.quizz.model.bean.Respuesta;

public interface IRespuestaService extends IService<Respuesta> {

	List<Respuesta> recuperarDePregunta(Integer id);

}
