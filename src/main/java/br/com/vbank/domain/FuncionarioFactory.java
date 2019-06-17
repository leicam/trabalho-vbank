package br.com.vbank.domain;

import br.com.vbank.enumerator.CargoFuncionario;
import br.com.vbank.exception.CargoInexistenteException;

public class FuncionarioFactory implements Contratavel<Funcionario> {

	@Override
	public Funcionario create(Funcionario funcionario, Agencia agencia) {
		CargoFuncionario cargo = funcionario.getCargo();

		if (CargoFuncionario.SUPORTE_CLIENTE.equals(cargo))
			return new SuporteCliente(funcionario, agencia);

		else if (CargoFuncionario.GERENTE_CONTA.equals(cargo))
			return new GerenteDeConta(funcionario, agencia);

		else if (CargoFuncionario.GERENTE_OPERACAO.equals(cargo))
			return new GerenteDeOperacao(funcionario, agencia);

		else if (CargoFuncionario.GERENTE_SEGURANCA.equals(cargo))
			return new GerenteDeSeguranca(funcionario, agencia);

		else
			throw new CargoInexistenteException();
	}

}
