package br.com.vbank.exception;

public class CargoInexistenteException extends RuntimeException {
	
	@Override
	public String getMessage() {
		return "Cargo inexistente.";
	}

}
