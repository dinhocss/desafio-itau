package br.com.itau.desafio.controller;

import br.com.itau.desafio.model.TransacaoRequest;
import br.com.itau.desafio.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {
	@Autowired
	TransacaoService service;
	
	@PostMapping
	public ResponseEntity<Void> criarTransacao(@Valid @RequestBody TransacaoRequest transacao){
		service.criarTransacao(transacao);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@DeleteMapping
	public ResponseEntity<Void> apagarTransacoes(){
		service.apagarTransacoes();
		
		return ResponseEntity.ok().build();
	}

}
