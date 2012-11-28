package com.movember.quizz.controller.dto;

public abstract class AbstractDTO {
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public abstract void toRest(Object object);

	public abstract void toBusiness(Object object);
}
