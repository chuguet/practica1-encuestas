package com.movember.quizz.model.service;

import java.util.List;
import com.movember.quizz.model.bean.Encuesta;
import com.movember.quizz.model.bean.ParametrosEncuesta;
import com.movember.quizz.model.exception.AppException;

public interface IEncuestaService extends IService<Encuesta> {

	List<Encuesta> find(ParametrosEncuesta parametrosEncuesta) throws AppException;

}
