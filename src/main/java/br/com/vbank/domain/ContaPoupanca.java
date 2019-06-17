package br.com.vbank.domain;

import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.vbank.repository.ContaPoupancaRepository;

@Entity
@Table(name = "conta_poupanca")
public class ContaPoupanca extends Conta {

	@EJB
	private ContaPoupancaRepository contaPoupancaRepo;

	@OneToOne
	@JoinColumn(name = "conta_id")
	private Conta conta;
	
	public ContaPoupanca() {}

	public ContaPoupanca(Pessoa pessoa, Conta conta, Gerente gerente) {
		this.pessoa = pessoa;
		this.conta = conta;
		this.gerenteDaConta = gerente;
		this.saldo = new BigDecimal("0");
		contaPoupancaRepo.save(this);
	}
}
