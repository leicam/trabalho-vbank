package br.com.vbank.exception;

public class AgenciaDesconhecidaException extends RuntimeException {
	
	@Override
	public String getMessage() {
		return "Agencia inoperante.";
	}

}
