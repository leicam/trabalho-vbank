package br.com.vbank.repository.impl;

import br.com.vbank.domain.TransferenciaTed;
import br.com.vbank.repository.TransferenciaTedRepository;

public class TransferenciaTedRepositoryImpl extends AbstractRepositoryImpl<TransferenciaTed> implements TransferenciaTedRepository{

	public TransferenciaTedRepositoryImpl() {
		super(TransferenciaTed.class);
	}
}
