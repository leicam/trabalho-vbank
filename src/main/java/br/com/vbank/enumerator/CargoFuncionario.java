package br.com.vbank.enumerator;

import java.math.BigDecimal;

public enum CargoFuncionario {
	SUPORTE_CLIENTE(new BigDecimal("2000.00")), 
	GERENTE_CONTA(new BigDecimal("4000.00")),
	GERENTE_OPERACAO(new BigDecimal("3500.00")), 
	GERENTE_SEGURANCA(new BigDecimal("5000.00"));

	private BigDecimal salarioBase;

	CargoFuncionario(BigDecimal salario) {
		this.salarioBase = salario;
	}

	public BigDecimal getSalarioBase() {
		return salarioBase;
	}

}
