package com.preguntados.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@GetMapping("/obtenerCategorias")
	public ResponseEntity<List<Categoria>> obtenerCategorias() {
		List<Categoria> categorias = categoriaDAO.findAll();
		return ResponseEntity.ok(categorias);	
	}

	@RequestMapping(value = "categoriaId/{categoriaId}", method = RequestMethod.POST)
	public ResponseEntity<Categoria> obtenerCategoria(@PathVariable("categoriaId") Long categoriaId) {
		Optional<Categoria> categoriaIndividual = categoriaDAO.findById(categoriaId);
		if (categoriaIndividual.isPresent()) {
			return ResponseEntity.ok(categoriaIndividual.get());
		} else {
			throw new Error("No existe la categoria con ese id");
		}
	}
		
	@ApiOperation(value = "Crea una categoria")
	@PostMapping("/creaCategoria")
	public ResponseEntity<Categoria> crearCategoria(@RequestBody Categoria categoria) {
		Categoria newCate = categoriaDAO.save(categoria);
		return ResponseEntity.ok(newCate);
	}
	
	@RequestMapping(value = "categoriaId", method = RequestMethod.DELETE)
	public ResponseEntity<Object> borrarCategoria(@PathVariable("categoriaId") Long categoriaId) {
		categoriaDAO.deleteById(categoriaId);
		return ResponseEntity.ok(null);
	}
}
