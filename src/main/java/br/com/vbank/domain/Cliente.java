package br.com.vbank.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.vbank.enumerator.StatusCliente;

@Entity
@Table(name = "cliente")
public class Cliente extends Pessoa {

	@OneToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;

	// arrumar, para poder utilizar no futuro agenciaVirtual e 1 agenciaFisica
	@OneToOne
	@JoinColumn(name = "agencia_id")
	private Agencia agencia;

	@OneToOne
	@JoinColumn(name = "conta_id")
	private Conta conta;

//	@NotNull
//	@Column(name = "pessoa_id", nullable = false)
//	private Long pessoaId;
//	private Integer cpf;
//	private Long contaId;

	@NotNull
	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusCliente statusCliente;

	public Cliente() {
	}

	public Cliente(Pessoa pessoa, Agencia agencia, Conta conta) {
		this.pessoa = pessoa;
		this.agencia = agencia;
		this.conta = conta;
		this.statusCliente = StatusCliente.ATIVADO;
//		this.cpf = cpf;
	}

//	public Cliente(String nome, Integer cpf, Integer cep, String numeroLogradouro) {
//		super(nome, cpf, cep, numeroLogradouro);
//		// TODO Auto-generated constructor stub
//	}

}
