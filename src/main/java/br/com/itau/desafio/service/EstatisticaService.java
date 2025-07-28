package br.com.itau.desafio.service;

import br.com.itau.desafio.model.EstatisticaResponse;
import br.com.itau.desafio.repository.TransacaoRepository;
import br.com.itau.desafio.model.TransacaoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.math.BigDecimal;
import java.math.RoundingMode;


@Service
public class EstatisticaService {
	@Autowired
	private TransacaoRepository repository;
	
	/*
	 * @return Objeto EstatisticaResponse com os dados calculados.
	 * */
	public EstatisticaResponse calcularEstatisticas() {
		List<TransacaoRequest> transacoesRecentes = repository.buscarUltimos60Segundos();
		
		if(transacoesRecentes.isEmpty()) {
			return new EstatisticaResponse(0L, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
		}
		
		long count = transacoesRecentes.size();
		BigDecimal sum = BigDecimal.ZERO;
		BigDecimal min = transacoesRecentes.get(0).getValor();
		BigDecimal max = transacoesRecentes.get(0).getValor();
		
		for(TransacaoRequest t:transacoesRecentes) {
			BigDecimal valorAtual = t.getValor();
			sum = sum.add(valorAtual);
			
			if(valorAtual.compareTo(min)<0) {
				min = valorAtual;
			}
			
			if(valorAtual.compareTo(max)>0) {
				max = valorAtual;
			}
		}
		
		BigDecimal avg = sum.divide(new BigDecimal(count),2,RoundingMode.HALF_UP);
		
		return new EstatisticaResponse(count,sum,avg,min,max);	
	}
	
	
}
