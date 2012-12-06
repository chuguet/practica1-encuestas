package com.movember.quizz.model.service;

import java.util.List;
import com.movember.quizz.model.bean.Pregunta;
import com.movember.quizz.model.exception.AppException;

public interface IPreguntaService extends IService<Pregunta> {
	List<Pregunta> recuperarDeEncuesta(Integer idEncuesta) throws AppException;
}
