package com.preguntados.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "respuesta")
public class Respuesta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "respuesta_id")
	private int respuestaID;
	
	@Column(name = "texto")
	private String texto;
	
	@Column(name = "es_correcta")
	private String esCorrecta;

	//@Column(name = "pregunta_id")
	//private int preguntaId;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "pregunta_id",referencedColumnName = "pregunta_id")
    private Pregunta opcion;
	
	public int getRespuestaID() {
		return respuestaID;
	}

	public void setRespuestaID(int respuestaID) {
		this.respuestaID = respuestaID;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getEsCorrecta() {
		return esCorrecta;
	}

	public void setEsCorrecta(String esCorrecta) {
		this.esCorrecta = esCorrecta;
	}

	/*public int getPreguntaId() {
		return preguntaId;
	}

	public void setPreguntaId(int preguntaId) {
		this.preguntaId = preguntaId;
	}*/
}
