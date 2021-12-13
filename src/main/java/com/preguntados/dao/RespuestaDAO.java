package com.preguntados.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.preguntados.entity.Pregunta;
import com.preguntados.entity.Respuesta;

public interface RespuestaDAO extends JpaRepository<Respuesta, Long>{

	//Optional<Respuesta> validarRepsuesta(Long preguntaId, Long respuestaId);

	
}
