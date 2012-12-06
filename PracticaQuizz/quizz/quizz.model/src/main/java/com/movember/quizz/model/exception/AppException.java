package com.movember.quizz.model.exception;

public class AppException extends Exception {

	private static final long serialVersionUID = 1L;

	public AppException() {
		super();
	}

	public AppException(String message) {
		super(message);
	}
}