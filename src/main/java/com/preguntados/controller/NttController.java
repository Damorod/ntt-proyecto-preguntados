package com.preguntados.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class NttController {
	
	@GetMapping("/tests")
	public String allAccess() {
		return "Mostrando contenido publico...";
	}

	@GetMapping("/test")
	public String userAccess() {
		return "Mostrando contenido para 'USER', 'MODERATOR' y 'ADMIN'...";
	}

	@GetMapping("/test1")
	public String moderatorAccess() {
		return "Mostrando contenido para 'MODERATOR'...";
	}

	@GetMapping("/test2")
	public String adminAccess() {
		return "Mostrando contenido para 'ADMIN'...";
	}
}
