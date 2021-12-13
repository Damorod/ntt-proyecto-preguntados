package com.preguntados.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.preguntados.entity.Categoria;
import com.preguntados.entity.Pregunta;

public interface PreguntaDAO extends JpaRepository<Pregunta, Integer>{
 

}
