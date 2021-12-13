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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "respuesta")
public class Respuesta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "respuesta_id")
	private Integer respuestaID;
	
	@Column(name = "texto")
	private String texto;
	
	@Column(name = "es_correcta")
	private String esCorrecta;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "pregunta_id",referencedColumnName = "pregunta_id")
	@JsonIgnore
    private Pregunta opcion;
	
	public Pregunta getOpcion() {
		return opcion;
	}

	public void setOpcion(Pregunta opcion) {
		this.opcion = opcion;
		this.opcion.agregarResp(this);
	}

	public Integer getRespuestaID() {
		return respuestaID;
	}

	public void setRespuestaID(Integer respuestaID) {
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

}
