package br.com.itau.desafio.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import jakarta.validation.constraints.*;


public class TransacaoRequest {
	@NotNull
	@PositiveOrZero
	private BigDecimal valor;
	
	@NotNull
	@PastOrPresent
	private OffsetDateTime dataHora;

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public OffsetDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(OffsetDateTime dataHora) {
		this.dataHora = dataHora;
	}
}
