package br.com.vbank.domain;

import br.com.vbank.enumerator.CargoFuncionario;

public class SuporteCliente extends Funcionario {

	public SuporteCliente(Funcionario funcionario, Agencia agencia) {
		super(funcionario.getPessoa(), agencia, CargoFuncionario.SUPORTE_CLIENTE, funcionario.getSalario());
	}

}
