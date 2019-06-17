package br.com.vbank.exception;

public class PropostaAberturaDeContaRejeitadaException extends RuntimeException {
	@Override
	public String getMessage() {
		return "Abertura de conta rejeitada.";
	}
}
