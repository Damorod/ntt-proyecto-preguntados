package com.preguntados.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.preguntados.dao.PreguntaDAO;
import com.preguntados.dao.RespuestaDAO;
import com.preguntados.entity.Pregunta;
import com.preguntados.entity.Respuesta;
import java.util.Random;

@RestController
@RequestMapping("/api/nttPreguntados")
public class NttController {

	@Autowired
	private RespuestaDAO respuestaDAO;
	@Autowired
	private PreguntaDAO preguntaDAO;
	
	@RequestMapping(value = "preguntaId/{preguntaId}/respuetsaId/{respuestaId}" , method = RequestMethod.GET)
	public String validarRespuesta(@PathVariable("preguntaId") Integer preguntaId, @PathVariable("respuestaId") Integer respuestaId ) {
		
		Optional<Pregunta> preg = preguntaDAO.findById(preguntaId);
		Optional<Respuesta> resp = respuestaDAO.findById(respuestaId);
		if(!preg.isPresent()){
			throw new Error("No existe la pregunta con ese id");
		}
		if(!resp.isPresent())
		{
			throw new Error("No existe la respuesta con ese id");
		}
		
		for(Respuesta r : preg.get().getRespuestas()) {
			if(r.getEsCorrecta().equals("true")) {
				return resp.get().getEsCorrecta();
			}
		}
		return null;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Pregunta> obtenerPreguntaAleatoria() {
		List<Pregunta> preguntas = preguntaDAO.findAll();
		
		int cantPreguntas = preguntas.size();
		int min = 1;
		
		Random random = new Random();
		
		Integer numRandom = random.nextInt(cantPreguntas - min + 1) + min;
		
		try {
			Optional<Pregunta> preguntaIndividual = preguntaDAO.findById(numRandom);
			preguntaIndividual.get().setIdCategoria(preguntaIndividual.get().getCateg().getCategoriaId());
			if (preguntaIndividual.isPresent()) {
				return ResponseEntity.ok(preguntaIndividual.get());
			} 
		}catch (Exception e){
			return ResponseEntity.noContent().build();
		}
		return null;
		
	}
	

}
