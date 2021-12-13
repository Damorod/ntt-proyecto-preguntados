package com.preguntados.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;

import com.fasterxml.jackson.annotation.JsonIgnore;

import springfox.documentation.annotations.ApiIgnore;

@Entity
@Table(name = "pregunta")
public class Pregunta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pregunta_id")
	private Long preguntaId;

	@Column(name = "enunciado")
	private String enunciado;
	
	@OneToMany(mappedBy = "opcion", cascade = CascadeType.ALL)
	private List<Respuesta> respuestas;
			
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id",referencedColumnName = "categoria_id")
	@JsonIgnore
    private Categoria categ;
	
	@Transient
    private Long idCategoria;

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Long getPreguntaId() {
		return preguntaId;
	}

	public void setPreguntaId(Long preguntaId) {
		this.preguntaId = preguntaId;
	}

	public List<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

	public Categoria getCateg() {
		return categ;
	}

	public void setCateg(Categoria categ) {
		this.categ = categ;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

}
