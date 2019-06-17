package br.com.vbank.exception;

public class CPFJaPossuiCadastroException extends RuntimeException {

	@Override
	public String getMessage() {
		return "CPF já possui cadastro.";
	}
}
