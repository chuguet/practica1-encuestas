package com.movember.quizz.model.service;

import com.movember.quizz.model.bean.Estadistica;
import com.movember.quizz.model.exception.AppException;


public interface IEstadisticaService {
	Estadistica retrieve (Integer pIdEncuesta) throws AppException;
}
