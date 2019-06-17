package br.com.vbank.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("DOC")
public class TransferenciaDoc extends Transferencia{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "conta_destino_id")
	protected ContaDestino contaDestino;
	
	@NotNull
	@Column(name = "taxa_transferencia")
	private BigDecimal taxaTransferencia;
	
	public TransferenciaDoc() {
		taxaTransferencia = this.valorTransferencia.multiply(BigDecimal.valueOf(0.10));
	}
}
