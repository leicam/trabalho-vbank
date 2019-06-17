package br.com.vbank.repository.impl;

import br.com.vbank.domain.ContaPoupanca;
import br.com.vbank.repository.ContaPoupancaRepository;

public class ContaPoupancaRepositoryImpl extends AbstractRepositoryImpl<ContaPoupanca> implements ContaPoupancaRepository {
//public class ContaPoupancaRepositoryImpl extends AbstractRepositoryImpl<ContaPoupanca> implements ContaRepository {

	public ContaPoupancaRepositoryImpl() {
		super(ContaPoupanca.class);
	}

}
