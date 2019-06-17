package br.com.vbank.exception;

public class NomeDePessoaInvalidoException extends RuntimeException {

	@Override
	public String getMessage() {
		return "Nome de pessoa inválido.";
	}
}
