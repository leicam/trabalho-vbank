package br.com.vbank.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Gerente extends Funcionario {

//	public Gerente(Pessoa pessoa, Agencia agencia, CargoFuncionario cargo, BigDecimal salario) {
//		super(pessoa, agencia, cargo, salario);
//	}

}
