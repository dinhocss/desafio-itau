package br.com.itau.desafio.repository;

import br.com.itau.desafio.model.TransacaoRequest;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

//Classe que irá gerenciar e armazenar os dados
@Repository
public class TransacaoRepository {
	private List<TransacaoRequest> transacoes = new CopyOnWriteArrayList<>();
	
	/*
	 * @param transacao O objeto de transação que será salvo
	 * */
	public void salvar(TransacaoRequest transacao) {
		this.transacoes.add(transacao);
	}
	
	public void apagarTodas() {
		this.transacoes.clear();
	}
	
	/*
	 * @return Lista com transações feitas nos últimos 60 segundos.
	 * */
	public List<TransacaoRequest> buscarUltimos60Segundos(){
		OffsetDateTime agora = OffsetDateTime.now();
		OffsetDateTime limite = agora.minusSeconds(60);
		
		return transacoes.stream().filter(t->t.getDataHora().isAfter(limite)).collect(Collectors.toList());
	}
}
