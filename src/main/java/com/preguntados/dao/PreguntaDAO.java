package com.preguntados.dao;

import java.util.List;

import com.preguntados.entity.Pregunta;

public interface PreguntaDAO {
 
	public List<Pregunta> obtenerTodasLasPreguntas();
	public Pregunta obtenerPreguntaEspecifica(int idPregunta);
	public Pregunta obtenerPreguntaAleatoria();
	public void crearPregunta();
}
