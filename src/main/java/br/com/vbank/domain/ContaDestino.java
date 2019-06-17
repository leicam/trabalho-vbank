package br.com.vbank.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "conta_destino")
public class ContaDestino extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(name = "documento")
	private String documento;
	
	@NotNull
	@Column(name = "codigo_banco")
	private int codigoBanco;
	
	@NotNull
	@Column(name = "codigo_agencia")
	private int codigoAgencia;
	
	@NotNull
	@Column(name = "numero_conta")
	private int numeroConta;
	
	@NotNull
	@Column(name = "digito_verificador")
	private int digitoVerificador;
	
	public ContaDestino() {}
}
