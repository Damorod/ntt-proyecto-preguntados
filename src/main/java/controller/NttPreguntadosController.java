package controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class NttPreguntadosController {
	
//	@RequestMapping(value = "", method = RequestMethod.GET)
//	@ApiOperation(value = "Pantalla Home", notes = "Pantalla de inicio")
//	@ApiResponses({ @ApiResponse(code = 200, message = "test") })
//	public String home() {
//		return "test";
//	}
	
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
