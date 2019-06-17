package br.com.vbank.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.vbank.enumerator.SituacaoOperacao;

@SuppressWarnings("serial")
@Table(name = "operacao")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo_operacao")
@MappedSuperclass()
public abstract class Operacao extends BaseEntity{
	//@Column(name = "tipo_operacao", insertable = false, )
	//private String tipoOperacao;
	
	@NotNull
	@Column(name = "situacao_operacao", nullable = false)
	protected SituacaoOperacao situacaoOperacao;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	protected Cliente cliente;
	
	@NotNull
	@Column(name = "data", nullable = false)
	protected Date data;
	
	public SituacaoOperacao getSituacaoOperacao() {
		return situacaoOperacao;
	}

	public void setSituacaoOperacao(SituacaoOperacao situacaoOperacao) {
		this.situacaoOperacao = situacaoOperacao;
	}

	public Operacao() {}
}
