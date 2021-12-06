package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("preguntados")
public class NttPreguntadosController {
	
	@GetMapping("/test")
	public String allAccess() {
		return "test...";
	}

	@PostMapping("/test1")
	public String userAccess() {
		return "test1'...";
	}

	@GetMapping("/test2")
	public String moderatorAccess() {
		return "test2'...";
	}

	@GetMapping("/test3")
	public String adminAccess() {
		return "test3...";
	}
}
