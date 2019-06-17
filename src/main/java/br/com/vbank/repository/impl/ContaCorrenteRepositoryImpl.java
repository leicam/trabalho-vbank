package br.com.vbank.repository.impl;

import br.com.vbank.domain.ContaCorrente;
import br.com.vbank.repository.ContaCorrenteRepository;

public class ContaCorrenteRepositoryImpl extends AbstractRepositoryImpl<ContaCorrente> implements ContaCorrenteRepository {

	public ContaCorrenteRepositoryImpl() {
		super(ContaCorrente.class);
	}

}
