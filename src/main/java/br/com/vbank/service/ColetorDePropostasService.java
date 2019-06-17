package br.com.vbank.service;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

import br.com.vbank.enumerator.ConfigConta;
import br.com.vbank.repository.PropostaAberturaDeContaRepository;

@Stateless
public class ColetorDePropostasService {
	
	@EJB
	PropostaAberturaDeContaRepository propostasRepo;
	
//	@Schedule(second="*", minute="*", hour="*/24", dayOfMonth="*", persistent = true)
	@Schedule(hour = "23", minute = "59", timezone = "BRT")
	public void retiraPropostasAberturaContaComPrazoVencido() {
		propostasRepo.removeTodasPropostasForaDoPrazo(ConfigConta.PRAZO_ABERTURA_CONTA.getValor());
	}

}
