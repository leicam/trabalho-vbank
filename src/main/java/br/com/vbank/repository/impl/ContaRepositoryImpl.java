package br.com.vbank.repository.impl;

import br.com.vbank.domain.Conta;
import br.com.vbank.repository.ContaRepository;

public class ContaRepositoryImpl extends AbstractRepositoryImpl<Conta> implements ContaRepository {

	public ContaRepositoryImpl() {
		super(Conta.class);
	}

}
