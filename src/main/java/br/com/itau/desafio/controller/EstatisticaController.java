package br.com.itau.desafio.controller;

import br.com.itau.desafio.model.EstatisticaResponse;
import br.com.itau.desafio.service.EstatisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

	@Autowired
	EstatisticaService service;
	
	@GetMapping
	public ResponseEntity<EstatisticaResponse> obterEstatisticas(){
		EstatisticaResponse estatisticas = service.calcularEstatisticas();
		
		return ResponseEntity.ok(estatisticas);
	}
}
