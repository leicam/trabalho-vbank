package br.com.vbank.domain;

import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.vbank.repository.ContaCorrenteRepository;

@Entity
@Table(name = "conta_corrente")
public class ContaCorrente extends Conta {

	@EJB
	private ContaCorrenteRepository contaCorrenteRepo;

	@OneToOne
	@JoinColumn(name = "conta_id")
	private Conta conta;
	
	public ContaCorrente() {}

	public ContaCorrente(Pessoa pessoa, Conta conta, Gerente gerente) {
		this.pessoa = pessoa;
		this.conta = conta;
		this.gerenteDaConta = gerente;
		this.saldo = new BigDecimal("0");
		contaCorrenteRepo.save(this);
	}
}
