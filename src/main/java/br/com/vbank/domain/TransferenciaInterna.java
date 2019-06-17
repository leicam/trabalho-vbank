package br.com.vbank.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("INTERNA")
public class TransferenciaInterna extends Transferencia{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "conta_destino_id")
	protected Conta contaDestino;
	
	public Conta getContaDestino() {
		return contaDestino;
	}
	
	public TransferenciaInterna() {}

}
