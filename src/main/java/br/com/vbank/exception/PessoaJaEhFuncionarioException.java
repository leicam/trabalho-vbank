package br.com.vbank.exception;

public class PessoaJaEhFuncionarioException extends RuntimeException {

	@Override
	public String getMessage() {
		return "Pessoa já é funcionário.";
	}
}
