package com.preguntados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.preguntados.dao.PreguntaDAO;
import com.preguntados.entity.Pregunta;

@RestController
@RequestMapping("/api")
public class PreguntaController {

	//@Autowired
	private PreguntaDAO preguntaDAO;
	
	@GetMapping("/obtenerTodasPreguntas")
	public String obtenerTodasPreguntas() {
		return "Mostrando contenido para 'USER', 'MODERATOR' y 'ADMIN'...";
	}

	@RequestMapping(value = "preguntaId", method = RequestMethod.POST)
	public Pregunta obtenerPregunta(@PathVariable("preguntaId") int preguntaId) {
		Pregunta preg = preguntaDAO.obtenerPreguntaEspecifica(preguntaId);
		return preg;
	}
	
	@PostMapping("/creaPregunta")
	public void creaPregunta() {
		//"Mostrando contenido para 'MODERATOR'...";
	}
}
