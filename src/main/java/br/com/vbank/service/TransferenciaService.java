package br.com.vbank.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.vbank.domain.TransferenciaDoc;
import br.com.vbank.domain.TransferenciaTed;
import br.com.vbank.repository.TransferenciaDocRepository;
import br.com.vbank.repository.TransferenciaTedRepository;

@Stateless
public class TransferenciaService {

	@Inject
	private TransferenciaTedRepository transferenciaTedRepository;
	@Inject
	private TransferenciaDocRepository transferenciaDocRepository;
	
	public boolean ted(TransferenciaTed transferenciaTed) {
		return transferenciaTedRepository.save(transferenciaTed).getId() != null;
	}
	
	public boolean doc(TransferenciaDoc transferenciaDoc) {
		return transferenciaDocRepository.save(transferenciaDoc).getId() != null; 
	}
	
	public boolean transferir(TransferenciaInterna transferenciaInterna) {
		return true;
	}
}
