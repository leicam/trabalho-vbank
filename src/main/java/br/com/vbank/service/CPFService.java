package br.com.vbank.service;

public class CPFService {

	public Integer valida(Integer cpf) {
		if (cpf.equals(null)) {
			throw new IllegalArgumentException("CPF Inválido!");
		}
		return cpf;
	}

}
