package br.com.vbank.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.vbank.enumerator.CargoFuncionario;
import br.com.vbank.enumerator.TipoAgencia;

@Entity
@Table(name = "agencia")
public class Agencia extends Banco {

	@NotNull
	@Column(name = "tipo_agencia", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoAgencia tipoAgencia;

	@ManyToOne
	@JoinColumn(name = "banco_id")
	private Banco banco;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "agencia")
	private Set<Funcionario> funcionarios = new HashSet<>();

//	@EJB
//	private AgenciaRepository agenciaRepo;
//
//	@Inject
//	PessoaService pessoaServ;
//
//	@EJB
//	FuncionarioRepository funcionarioRepo;

	public Agencia() {
	}

	protected Agencia(TipoAgencia tipoAgencia, Banco banco) {
		this.tipoAgencia = tipoAgencia;
		this.banco = banco;
//		agenciaRepo.save(this);
	}

//	// ver como Gson deserializa gerando objeto, ver tipos como, pq n tem como gerar objeto Funcionario, refatorar a factory pra CargoFuncionario
//	public Long registraFuncionario(Funcionario funcionario) {
//		Funcionario funcionarioRegistrado = new FuncionarioFactory().create(funcionario, this);
//		funcionarioRepo.save(funcionario);
//		return funcionarioRegistrado.getId();
//	}
//
//	public Agencia localizaAgencia(Long agenciaId) {
//		return agenciaRepo.findById(agenciaId);
//	}

	public void adicionaFuncionario(Funcionario fun) {
		this.funcionarios.add(fun);
		fun.setAgencia(this);
	}

	public Set<Funcionario> getFuncionarios() {
		return Collections.unmodifiableSet(funcionarios);
	}
}
