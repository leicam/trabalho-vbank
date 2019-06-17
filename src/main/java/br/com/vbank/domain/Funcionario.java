package br.com.vbank.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.vbank.enumerator.CargoFuncionario;
import br.com.vbank.enumerator.StatusFuncionario;

@Entity
@Table(name="funcionario")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo_funcionario")
public abstract class Funcionario extends BaseEntity{

	// many pois caso for demitido e recontratado ou mudar de carga e permanecer
	// objeto antigo no bd
	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;

	@ManyToOne
	@JoinColumn(name = "agencia_id")
	@NotNull
	private Agencia agencia;

	@NotNull
	@Column(name = "matricula", nullable = false)
	private Integer matricula;

	@NotNull
//	@Temporal(TemporalType.DATE)
	@Column(name = "data_contratacao", nullable = false)
	private LocalDate dataDaContratacao;

	@Enumerated(EnumType.STRING)
	@NotNull
	@Column(name = "cargo", nullable = false)
	private CargoFuncionario cargoFuncionario;

//	@Digits(integer=7, fraction=2)
	@NotNull
	@Column(name = "salario", precision = 7, scale = 2, nullable = false)
	private BigDecimal salario;

	@NotNull
	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusFuncionario statusFuncionario;

//	@EJB
//	FuncionarioRepository funcionarioRepo;
	
	public Funcionario() {}

//	public Funcionario(Pessoa pessoa, Agencia agencia, CargoFuncionario cargo, BigDecimal salario) {
//		if (funcionarioRepo.findFuncionarioAtivoByPessoaId(pessoa.getId()))
//			throw new PessoaJaEhFuncionarioException();
//		this.pessoa = pessoa;
//		this.agencia = agencia;
//		this.matricula = this.getId().intValue();
//		this.dataDaContratacao = LocalDate.now();
//		this.cargoFuncionario = cargo;
//		if (salario != null)
//			this.salario = salario;
//		else
//			this.salario = cargo.getSalarioBase();
//	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	
	public Agencia getAgencia() {
		return agencia;
	}

	public CargoFuncionario getCargo() {
		return cargoFuncionario;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public BigDecimal getSalario() {
		return salario;
	}

//	public String toJson() {
//		return new Gson().toJson(this);
//	}

//	public Funcionario abstractToJson() {
//		GsonBuilder gsonBuilder = new GsonBuilder()
//		gsonBuilder.registerTypeAdapter(Funcionario.class, new InterfaceAdapter<Funcionario>());
//		Gson gson = gsonBuilder.create();
//		
//		String str2send = gson.toJson(message);
//		Mensagem msg_recv = gson.fromJson(str2send,Mensagem.class);
//		//https://stackoverflow.com/questions/16000163/using-gson-and-abstract-classes
//	}
	

}
