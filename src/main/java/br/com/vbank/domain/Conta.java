package br.com.vbank.domain;

import java.math.BigDecimal;
import java.util.Random;

import javax.ejb.EJB;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.vbank.repository.ContaRepository;

//@DiscriminatorColumn(name)
@Entity
@Table(name = "conta")
public class Conta extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(name = "numero_conta", nullable = false)
	private Integer numeroDaConta;

	@NotNull
	@Column(name = "senha_temporaria", length = 4, nullable = false)
	@Size(min = 4, max = 4)
	private Integer senhaTemporaria;

	@Column(name = "senha_conta", length = 6)
	@Size(min = 6, max = 6)
	private Integer senhaDaConta;

	@OneToOne
	@JoinColumn(name = "pessoa_id")
	protected Pessoa pessoa;

	@OneToOne
	@JoinColumn(name = "cliente_id")
	protected Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "gerente_id")
//	protected Gerente gerenteDaConta;
	protected Funcionario gerenteDaConta;

	@Transient
	protected BigDecimal saldo;

	@EJB
	ContaRepository contaRepo;

	protected Conta() {
	}

	public Conta(Pessoa pessoa, Cliente cliente, Gerente gerente) {
		this.numeroDaConta = this.getId().intValue();
//		this.numeroDaConta = contaRepo.getQuantidadeDeContas() + 1; ou atributo static
		this.senhaTemporaria = new Random().nextInt(8999) + 1000;
		this.senhaDaConta = null;
		this.pessoa = pessoa;
		this.cliente = cliente;
		this.gerenteDaConta = gerente;
		geraContaPoupancaECorrente(); // como se fosse o plano escolhido
		contaRepo.save(this);
	}

	private void geraContaPoupancaECorrente() {
		new ContaPoupanca(pessoa, this, gerenteDaConta);
		new ContaCorrente(pessoa, this, gerenteDaConta);
	}

	public void enviaEmailSejaBemVindo() {

	}

	public Integer getNumeroConta() {
		return numeroDaConta;
	}

	public Integer getSenhaTemporaria() {
		return senhaTemporaria;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}
}
