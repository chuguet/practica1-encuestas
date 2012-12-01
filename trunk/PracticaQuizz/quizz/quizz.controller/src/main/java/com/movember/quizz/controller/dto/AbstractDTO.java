package com.movember.quizz.controller.dto;

public abstract class AbstractDTO {
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public abstract void toRest(Object object);

	public abstract void toBusiness(Object object);
}
