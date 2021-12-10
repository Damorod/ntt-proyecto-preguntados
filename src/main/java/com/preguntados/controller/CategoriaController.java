package com.preguntados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.preguntados.dao.CategoriaDAO;
import com.preguntados.dao.PreguntaDAO;
import com.preguntados.entity.Categoria;
import com.preguntados.entity.Pregunta;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class CategoriaController {
	
	//@Autowired
	private CategoriaDAO categoriaDAO;
	
	@GetMapping("/obtenerCategorias")
	public String obtenerCategorias() {
		return "Mostrando contenido para 'USER', 'MODERATOR' y 'ADMIN'...";
	}

	@RequestMapping(value = "categoriaId", method = RequestMethod.POST)
	public Categoria obtenerCategoria(@PathVariable("categoriaId") int categoriaId) {
		Categoria categoria = categoriaDAO.obtenerCategoriaEspecifica(categoriaId);
		return categoria;
	}
	
	@ApiOperation(value = "Crea una categoria")
	@PostMapping("/creaCategoria")
	public void crearCategoria() {
		//"Mostrando contenido para 'MODERATOR'...";
	}
	
	@RequestMapping(value = "categoriaId", method = RequestMethod.DELETE)
	public void borrarCategoria(@PathVariable("categoriaId") int categoriaId) {
		categoriaDAO.eliminarCategoria(categoriaId);
	}
}
