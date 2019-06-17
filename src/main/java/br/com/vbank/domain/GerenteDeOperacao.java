package br.com.vbank.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.OneToOne;

import br.com.vbank.enumerator.CargoFuncionario;

@DiscriminatorValue("GO")
public class GerenteDeOperacao extends Gerente {

//	@OneToOne
//	private Funcionario funcionario;

//	public GerenteDeOperacao(Funcionario funcionario, Agencia agencia) {
//		super(funcionario.getPessoa(), agencia, CargoFuncionario.GERENTE_OPERACAO, funcionario.getSalario());
////		funcionarioRepo.save(this);
//	}

}
