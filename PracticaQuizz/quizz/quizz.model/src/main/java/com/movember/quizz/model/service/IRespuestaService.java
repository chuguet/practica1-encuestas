package com.movember.quizz.model.service;

import java.util.List;
import com.movember.quizz.model.bean.Respuesta;
import com.movember.quizz.model.exception.AppException;

public interface IRespuestaService extends IService<Respuesta> {

	List<Respuesta> recuperarDePregunta(Integer id) throws AppException;
	Integer recuperarVecesContestadas (Integer idRespuesta) throws AppException;
}
