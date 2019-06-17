package br.com.vbank.exception;

public class JaPossuiPropostaEmAnaliseException extends RuntimeException {
	
	@Override
	public String getMessage() {
		return "Já possui proposta em análise.";
	}

}
