package com.preguntados.dao;

import java.util.List;

import com.preguntados.entity.Categoria;

public interface CategoriaDAO {

	public List<Categoria> obtenerTodasLasCategorias();
	public Categoria obtenerCategoriaEspecifica(int categoriaId);
	public void eliminarCategoria(int categoriaId);
	public void crearCategoria();
	
}
