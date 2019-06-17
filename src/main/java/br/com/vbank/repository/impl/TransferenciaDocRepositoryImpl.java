package br.com.vbank.repository.impl;

import br.com.vbank.domain.TransferenciaDoc;
import br.com.vbank.repository.TransferenciaDocRepository;

public class TransferenciaDocRepositoryImpl extends AbstractRepositoryImpl<TransferenciaDoc> implements TransferenciaDocRepository{

	public TransferenciaDocRepositoryImpl() {
		super(TransferenciaDoc.class);
	}

}
