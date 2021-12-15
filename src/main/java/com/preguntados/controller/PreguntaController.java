package com.preguntados.controller;

import java.util.ArrayList;
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
import com.preguntados.dao.RespuestaDAO;
import com.preguntados.entity.Categoria;
import com.preguntados.entity.Pregunta;
import com.preguntados.entity.Respuesta;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/preguntas")
public class PreguntaController {

	@Autowired
	private PreguntaDAO preguntaDAO;
	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@GetMapping("/obtenerTodasPreguntas")
	public ResponseEntity<List<Pregunta>> obtenerTodasPreguntas() {
		List<Pregunta> preguntas = preguntaDAO.findAll();
		return ResponseEntity.ok(preguntas);	
	}

	@RequestMapping(value = "preguntaId/{preguntaId}", method = RequestMethod.GET)
	public ResponseEntity<Pregunta> obtenerPregunta(@PathVariable("preguntaId") Integer preguntaId) {
		Optional<Pregunta> preguntaIndividual = preguntaDAO.findById(preguntaId);
		if (preguntaIndividual.isPresent()) {
			return ResponseEntity.ok(preguntaIndividual.get());
		} else {
			throw new Error("No existe la pregunta con ese id");
		}
	}
	
	@ApiOperation(value = "Crea una pregunta")
	@PostMapping("/creaPregunta")
	public ResponseEntity<Pregunta> creaPregunta(@RequestBody Pregunta pregunta) {
		Pregunta preg = new Pregunta();
		preg.setEnunciado(pregunta.getEnunciado());
		Optional<Categoria> categ  = categoriaDAO.findById(pregunta.getIdCategoria());
		if(categ.isPresent()) {
			preg.setCateg(categ.get());
		}else {
			throw new Error("No existe la categoria");
		}
		if(preguntaDAO.findById(pregunta.getPreguntaId()).isPresent()) {
			throw new Error("Ya existe la pregunta con ese id");
		}
		preg.setPreguntaId(pregunta.getPreguntaId());
		List<Respuesta> respuestas = pregunta.getRespuestas();
		for(Respuesta res : respuestas) {
			res.setOpcion(preg);
		}
		preg.setRespuestas(respuestas);
		preg.setIdCategoria(pregunta.getIdCategoria());
		preguntaDAO.save(preg);
		return ResponseEntity.ok(preg);
	}
}
