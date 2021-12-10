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

import org.hibernate.annotations.LazyCollection;

@Entity
@Table(name = "pregunta")
public class Pregunta {

	@Id
	@Column(name = "pregunta_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pregunta_id;

	//@Column(name = "categoria_id")
	//private int categoriaId;

	@Column(name = "enunciado")
	private String enunciado;
	
	@OneToMany(mappedBy = "opcion", cascade = CascadeType.ALL)
	private List<Respuesta> respuestas;
			
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id",referencedColumnName = "categoria_id")
    private Categoria categ;
	
/*	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

/*	public int getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(int categoriaId) {
		this.categoriaId = categoriaId;
	}*/

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

}
