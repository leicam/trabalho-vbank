package br.com.vbank.domain;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("GS")
public class GerenteDeSeguranca extends Gerente {

//	@OneToOne
//	private Funcionario funcionario;

//	public GerenteDeSeguranca(Funcionario funcionario, Agencia agencia) {
//		super(funcionario.getPessoa(), agencia, CargoFuncionario.GERENTE_SEGURANCA, funcionario.getSalario());
////		funcionarioRepo.save(this);
//	}

}
