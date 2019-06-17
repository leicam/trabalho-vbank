package br.com.vbank.repository.impl;

import br.com.vbank.domain.Agencia;
import br.com.vbank.repository.AgenciaRepository;

public class AgenciaRepositoryImpl extends AbstractRepositoryImpl<Agencia> implements AgenciaRepository {

	public AgenciaRepositoryImpl() {
		super(Agencia.class);
	}

}
