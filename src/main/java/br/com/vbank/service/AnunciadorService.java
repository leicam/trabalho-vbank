package br.com.vbank.service;

import javax.ejb.Singleton;

import br.com.vbank.domain.Conta;
import br.com.vbank.enumerator.MotivoDecisaoPropostaAberturaDeConta;

//??
@Singleton
public class AnunciadorService {
	
//	https://www.baeldung.com/java-email
	
	public void enviarEmail(Long pessoaId, Integer numeroConta, Integer senhaTemporaria) {
//		passar nome parametro
		System.out.println("Seja bem-vindo %fulano, sua proposta de abertura de conta foi aprovada.");
		System.out.println("Numero da conta:" + numeroConta);
		System.out.println("Senha temporária: " + senhaTemporaria);
	}

	public void enviarEmail(Long pessoaId, MotivoDecisaoPropostaAberturaDeConta motivo) {
		System.out.println("Nós do VBank sintimos muito mas sua proposta de abertura de conta não foi aprovada.");
		System.out.println("Motivo: " + motivo);
	}

}
