package br.com.vbank.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass()
public abstract class Transferencia extends Operacao {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "conta_origem_id")
	protected Conta contaOrigem;
	
	@NotNull
	@Column(name = "valor_transferencia", nullable = false)
	protected BigDecimal valorTransferencia;

	public Conta getContaOrigem() {
		return contaOrigem;
	}
	
	public BigDecimal getValorTransferencia() {
		return valorTransferencia;
	}
}
