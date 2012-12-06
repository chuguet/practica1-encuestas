package com.movember.quizz.controller.dto;

import com.movember.quizz.model.exception.AppException;

public abstract class AbstractDTO {
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public abstract void toRest(Object object) throws AppException;

	public abstract void toBusiness(Object object) throws AppException;
}
