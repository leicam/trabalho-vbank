package br.com.vbank.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.vbank.enumerator.TipoAgencia;

@Entity
@Table(name = "banco")
public class Banco extends BaseEntity {
	
	@Column(name = "nome")
	private String nome;
	
//	private Set<Agencia> agencias;
//	private Set<Conta> contas;
//	private Set<Funcionario> funcionarios;
//
//	public Banco() {
//		agencias = new HashSet<>();
//		contas = new HashSet<>();
//		funcionarios = new HashSet<>();
//	}
	
	public void criarAgencia(TipoAgencia tipoAgencia) {
		new Agencia(tipoAgencia, this);
	}
}
