package br.com.vbank.repository.impl;

import javax.inject.Inject;

import br.com.vbank.domain.Conta;
import br.com.vbank.domain.TransferenciaInterna;
import br.com.vbank.repository.ContaRepository;
import br.com.vbank.repository.TransferenciaInternaRepository;

public class TransferenciaInternaRespositoryImpl extends AbstractRepositoryImpl<TransferenciaInterna> implements TransferenciaInternaRepository{

	@Inject
	private ContaRepository contaRespository;
	
	public TransferenciaInternaRespositoryImpl() {
		super(TransferenciaInterna.class);
	}

	@Override
	public boolean transferir(TransferenciaInterna transferencia) {
		Conta contaOrigem = contaRespository.findById(transferencia.getContaOrigem().getId());
		Conta contaDestino = contaRespository.findById(transferencia.getContaOrigem().getId());
		
		if(contaOrigem.getSaldo().compareTo(transferencia.getValorTransferencia()) == -1)
			throw new RuntimeException("Saldo insuficiente!");
		
		return true;
	}

}
