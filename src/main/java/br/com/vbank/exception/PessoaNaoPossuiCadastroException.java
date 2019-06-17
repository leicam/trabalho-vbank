package br.com.vbank.exception;

public class PessoaNaoPossuiCadastroException extends RuntimeException {
	
	@Override
	public String getMessage() {
		return "Pessoa não possui cadastro.";
	}

}
