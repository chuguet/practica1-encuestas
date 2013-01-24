package com.movember.quizz.model.bean;

/**
 * The Class RespuestaEstadistica.
 */
public class RespuestaEstadistica {

	/** The respuesta. */
	private String respuesta;

	private int vecesNoIdentificado;

	private int vecesIdentificado;

	/** The id pregunta. */
	private Integer idPregunta;

	/**
	 * Gets the respuesta.
	 * 
	 * @return the respuesta
	 */
	public String getRespuesta() {
		return respuesta;
	}

	/**
	 * Sets the respuesta.
	 * 
	 * @param respuesta
	 *            the new respuesta
	 */
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public int getVecesNoIdentificado() {
		return vecesNoIdentificado;
	}

	public void setVecesNoIdentificado(int vecesNoIdentificado) {
		this.vecesNoIdentificado = vecesNoIdentificado;
	}

	public int getVecesIdentificado() {
		return vecesIdentificado;
	}

	public void setVecesIdentificado(int vecesIdentificado) {
		this.vecesIdentificado = vecesIdentificado;
	}

	/**
	 * Gets the id pregunta.
	 * 
	 * @return the id pregunta
	 */
	public Integer getIdPregunta() {
		return idPregunta;
	}

	/**
	 * Sets the id pregunta.
	 * 
	 * @param idPregunta
	 *            the new id pregunta
	 */
	public void setIdPregunta(Integer idPregunta) {
		this.idPregunta = idPregunta;
	}
}
