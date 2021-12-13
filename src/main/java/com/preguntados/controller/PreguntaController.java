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
@RequestMapping("/api")
public class PreguntaController {

	@Autowired
	private PreguntaDAO preguntaDAO;
	@Autowired
	private RespuestaDAO respuestaDAO;
	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@GetMapping("/obtenerTodasPreguntas")
	public ResponseEntity<List<Pregunta>> obtenerTodasPreguntas() {
		List<Pregunta> preguntas = preguntaDAO.findAll();
		return ResponseEntity.ok(preguntas);	
	}

	@RequestMapping(value = "preguntaId/{preguntaId}", method = RequestMethod.GET)
	public ResponseEntity<Pregunta> obtenerPregunta(@PathVariable("preguntaId") Long preguntaId) {
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
		List<Respuesta> respuestas = new ArrayList<>();
		for(Respuesta res : pregunta.getRespuestas()) {
			Respuesta resp = new Respuesta();
			resp.setEsCorrecta(res.getEsCorrecta());
			resp.setRespuestaID(res.getRespuestaID());
			resp.setTexto(res.getTexto());
			resp.setOpcion(pregunta);
			respuestas.add(resp);
		}
		Optional<Categoria> categ  = categoriaDAO.findById(pregunta.getIdCategoria());
		if(categ.isPresent()) {
			pregunta.setCateg(categ.get());
		}else {
			throw new Error("No existe la categoria");
		}
		pregunta.setRespuestas(respuestas);
		preguntaDAO.save(pregunta);
		return ResponseEntity.ok(pregunta);
	}
}
