package com.preguntados.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.preguntados.entity.Categoria;

public interface CategoriaDAO extends JpaRepository<Categoria, Integer>{

	//public List<Categoria> obtenerTodasLasCategorias();
	//public Categoria obtenerCategoriaEspecifica(int categoriaId);
	//public void eliminarCategoria(int categoriaId);
	//public void crearCategoria();
	
}
