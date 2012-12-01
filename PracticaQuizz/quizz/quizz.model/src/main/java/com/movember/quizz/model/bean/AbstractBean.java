package com.movember.quizz.model.bean;

import org.hibernate.annotations.Entity;

@Entity
public abstract class AbstractBean {
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}