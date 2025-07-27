package br.com.itau.desafio.service;

import br.com.itau.desafio.model.TransacaoRequest;
import br.com.itau.desafio.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {
	@Autowired
	private TransacaoRepository repository;
	
	/*
	 * Orquestra a criação de uma nova transação
	 * @param transacao Os dados da transação a serem salvos
	 * */
	public void criarTransacao(TransacaoRequest transacao) {
		repository.salvar(transacao);
	}
	
	public void apagarTransacoes() {
		repository.apagarTodas();
	}
}
