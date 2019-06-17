package br.com.vbank.domain;

import javax.ejb.EJB;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.vbank.enumerator.StatusPessoa;
import br.com.vbank.exception.CPFJaPossuiCadastroException;
import br.com.vbank.exception.NomeDePessoaInvalidoException;
import br.com.vbank.repository.PessoaRepository;
import br.com.vbank.service.CEPService;
import br.com.vbank.service.CPFService;

@Entity
@Table(name = "pessoa")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Pessoa extends BaseEntity {

	@NotNull
	@Size(max = 50)
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;

	@NotNull
	@Column(name = "cpf", length = 11, nullable = false)
	@Size(min = 11, max = 11)
	private Integer cpf;

	@NotNull
	@Size(min = 5, max = 50)
	@Column(name = "email", length = 50, nullable = false)
	private String email;
	
	@NotNull
	@Column(name = "endereco", nullable = false)
	//ou Long enderecoId
	private Endereco endereco;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private StatusPessoa statusPessoa;
	
	//??vai precisar
	private Utente utente;

	@EJB
	private PessoaRepository pessoaRepo;

	protected Pessoa() {}

	public Pessoa(String nome, Integer cpf, Integer cep, String numeroLogradouro) {
		if (verificaSeCPFPossuiCadastro(cpf))
			throw new CPFJaPossuiCadastroException();

		this.nome = validaNomePessoa(nome);
		this.cpf = new CPFService().valida(cpf);
		this.endereco = new CEPService().validaEConsulta(cep, numeroLogradouro);
	}

	private String validaNomePessoa(String nome) {
		if (nome.trim().length() < 4)
			throw new NomeDePessoaInvalidoException();
		return nome;
	}

	private boolean verificaSeCPFPossuiCadastro(Integer cpf) {
		return pessoaRepo.findCPF(cpf);
	}

	public Integer getCPF() {
		return cpf;
	}

	// ---

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

}
