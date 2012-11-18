package quizz.movember.model.bean;

public class Pregunta {
	private Long id;
	private String pregunta;
	private Long id_encuesta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public Long getId_encuesta() {
		return id_encuesta;
	}

	public void setId_encuesta(Long id_encuesta) {
		this.id_encuesta = id_encuesta;
	}
}
