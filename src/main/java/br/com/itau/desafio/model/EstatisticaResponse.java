package br.com.itau.desafio.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import jakarta.validation.constraints.*;


public class EstatisticaResponse {
	private long count;
	private BigDecimal sum;
	private BigDecimal avg;
	private BigDecimal min;
	private BigDecimal max;
	
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public BigDecimal getSum() {
		return sum;
	}
	public void setSum(BigDecimal sum) {
		this.sum = sum;
	}
	public BigDecimal getAvg() {
		return avg;
	}
	public void setAvg(BigDecimal avg) {
		this.avg = avg;
	}
	public BigDecimal getMin() {
		return min;
	}
	public void setMin(BigDecimal min) {
		this.min = min;
	}
	public BigDecimal getMax() {
		return max;
	}
	public void setMax(BigDecimal max) {
		this.max = max;
	}

	
	
}
