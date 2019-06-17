package br.com.vbank.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.ejb.EJB;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.vbank.enumerator.SituacaoAberturaDeConta;
import br.com.vbank.enumerator.UF;
import br.com.vbank.exception.JaPossuiPropostaEmAnaliseException;
import br.com.vbank.exception.PropostaAberturaDeContaRejeitadaException;
import br.com.vbank.repository.PropostaAberturaDeContaRepository;

@Entity
@Table(name = "proposta_abertura_conta")
public class PropostaAberturaDeConta extends BaseEntity {
	
	@NotNull
	@Column(name = "numero_proposta", nullable = false)
	private Integer numeroDaProposta;

	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "uf", nullable = false)
	private UF uf;

	@NotNull
	@Column(name = "data_solicitacao", nullable = false)
	private LocalDate dataDaSolicitacao;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "situacao_abertura_conta", nullable = false)
	private SituacaoAberturaDeConta situacaoAberturaDeConta;

	@EJB
	private PropostaAberturaDeContaRepository propostaRepo;

	public PropostaAberturaDeConta() {}

	public PropostaAberturaDeConta(Pessoa pessoa, UF uf) {
		if (possuiPropostaEmSituacao(SituacaoAberturaDeConta.AGUARDANDO, pessoa.getId())) throw new JaPossuiPropostaEmAnaliseException();
		if (possuiPropostaEmSituacao(SituacaoAberturaDeConta.REJEITADA, pessoa.getId())) throw new PropostaAberturaDeContaRejeitadaException();

		this.numeroDaProposta = getId().intValue();
		this.pessoa = pessoa;
		this.uf = uf;
		this.dataDaSolicitacao = LocalDate.now();
		this.situacaoAberturaDeConta = SituacaoAberturaDeConta.AGUARDANDO;
		propostaRepo.save(this);
	}

	public boolean possuiPropostaEmSituacao(SituacaoAberturaDeConta situacaoAberturaDeConta, Long pessoaId) {
		return propostaRepo.possuiPropostaEmSituacao(situacaoAberturaDeConta, pessoaId);
	}

	public Long getPessoaId() {
		return pessoa.getId();
	}
	
	public Integer getNumeroDaProposta() {
		return numeroDaProposta;
	}
	
	public void aceitarProposta() {
		this.situacaoAberturaDeConta = SituacaoAberturaDeConta.APROVADA;
	}

}
