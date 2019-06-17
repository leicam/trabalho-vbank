package br.com.vbank.service;

import br.com.vbank.domain.Endereco;

public class CEPService {

	public Endereco validaEConsulta(Integer cep, String numeroLogradouro) {
		Endereco endereco = null;
		endereco.setNumeroLogradouro(numeroLogradouro);
		return endereco;
	}

}
